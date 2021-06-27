import edu.duke.*;
import java.io.*;

public class Image_Inversion
{
        public ImageResource makeInversion(ImageResource inImage)
    {
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
        for(Pixel pixel: outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY());
            int negRed = 255 - inPixel.getRed();
            int negGreen = 255 - inPixel.getGreen();
            int negBlue = 255 - inPixel.getBlue();
            pixel.setRed(negRed);
            pixel.setGreen(negGreen);
            pixel.setBlue(negBlue);   
        }
        return outImage;
    }
    
    public void SaveCopyImage(ImageResource inImage,String name,String accion){
        String newName =  "Copy-"+accion+name;
        inImage.setFileName(newName);
        inImage.save();   
    }
    
    public void selecAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource currentImg = new ImageResource(f);
            String name = currentImg.getFileName();
            ImageResource negative = makeInversion(currentImg);
            SaveCopyImage(negative,name,"Negative");
            negative.draw();
        }
    }
}
