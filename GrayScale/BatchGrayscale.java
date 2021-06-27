import edu.duke.*;
import java.io.*;
/**
 * Write a description of class BatchGrayscale here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BatchGrayscale
{
    
    public ImageResource makeGray(ImageResource inImage)
    {
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
        for(Pixel pixel: outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY());
            int average = (inPixel.getRed() + inPixel.getGreen()+ inPixel.getBlue())/3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);   
        }
        
        return outImage;
    }
    
    public void test(){
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
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
            ImageResource gray = makeGray(currentImg);
            SaveCopyImage(gray,name,"Gray");
            gray.draw();
        }
    }
}
