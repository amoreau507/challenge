package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Controller
public class ChallengeOne {
    @GetMapping("/1")
    public String getChallengeOne() throws IOException {
        //init();
        return "ch1";
    }

    private void init() throws IOException {
        BufferedImage bImage = ImageIO.read(new File("src/main/resources/static/image/ch1_bkg.jpg"));
        String ligne = "0100010101110011011101000010000001100011011001010010000001110001011101010110010100100000011101000111010100100000011000010111001100100000011101010110111001100101001000000110001001101001011001010111001001100101";
        String solution = "";
        for (int i = bImage.getMinX(); i < bImage.getWidth(); i++) {
            for (int j = bImage.getMinY(); j < bImage.getHeight(); j++) {
                if (j < ligne.length()) {
                    if (ligne.charAt(j) == '1') {
                        bImage.setRGB(i, j, 8224125);
                    }
                    solution += ligne.charAt(j);
                }
            }
        }
        System.out.println(solution);
        File outputfile = new File("src/main/resources/static/image/ch1_bkg2.jpg");
        ImageIO.write(bImage, "jpg", outputfile);

    }
}
