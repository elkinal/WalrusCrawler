package main;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alxye on 16-Apr-18.
 */
public class Program {

    private static URL url;
    private static String[] links;
    private static int con;
    public static void main(String[] args) {
        try {
            ArrayList<String> content = new ArrayList<>();
            ArrayList<String> images = new ArrayList<>();
            String control = "";
            url = new URL("http://www.bigshinybutton.com/");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = in.readLine()) != null) {
                content.add(line);
                if(line.contains("src")) {
                    //System.out.println(line.substring(line.indexOf("http"), line.indexOf(".png")));
//                    System.out.println(line);
                    control += line;

                }
            }
            links = control.split("src");
            String[] layer;
            String content2 = "";
            for (int i = 0; i < links.length; i++) {
                con += 1;
              content2 += links[i];
            }
            layer = content2.split(String.valueOf((char) 34));

            for (int i = 0; i < layer.length; i++) {
//                System.out.println(layer[i]);
                if(layer[i].contains(".")) {
                    images.add(layer[i]);
                }
            }
//            for (int i = 0; i < images.size(); i++) {
//                if(!images.get(i).contains("http"))
//                    images.set(i, String.valueOf(url) + images.get(i));
//            }
            images.forEach(System.out::println);

            //System.out.println(control);
           /* links = control.split(Character.toString((char) 34));
            for (int i = 0; i < links.length; i++) {
                System.out.println(links[i]);
//                if(links[i].startsWith("http"))
//                    images.add(links[i]);
            }
            images.forEach(System.out::println);
*/
            //content.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
