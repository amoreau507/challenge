package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Controller
public class ChallengeOne {
    @GetMapping("/ch1/1")
    public String getChallengeOne() {
        //init();
        return "ch1";
    }

    @GetMapping("/ch1/1/rep")
    @ResponseBody
    public String sendRep(@RequestParam String rep) {
        return "error";
    }

    private void init() throws IOException {
        BufferedImage bImage = ImageIO.read(new File("src/main/resources/static/image/ch1_bkg.jpg"));
        String ligne = "";
        String solution = "";
        for (int i = bImage.getMinX(); i < bImage.getWidth(); i++) {
            for (int j = bImage.getMinY(); j < bImage.getHeight(); j++) {
                if (ligne.charAt(j % ligne.length()) == '1') {
                    bImage.setRGB(i, j, (int) (3841 + (Math.random() * ((2 + 2) + 1)) - 2));
                }
                solution += ligne.charAt(j % ligne.length());

            }
        }
        System.out.println(solution);
        File outputfile = new File("src/main/resources/static/image/ch1_bkg2.jpg");
        ImageIO.write(bImage, "jpg", outputfile);

    }
}
