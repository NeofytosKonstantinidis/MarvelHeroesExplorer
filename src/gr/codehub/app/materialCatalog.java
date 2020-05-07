package gr.codehub.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class materialCatalog {
    private ArrayList<Material> materials = new ArrayList<>();

    public void addMaterial(Material material){
        materials.add(material);
    }
    public int GetSize(){ return materials.size(); }
    public void RemoveMaterial(int i){
        if (i>=0 && i <= materials.size()-1) {
            materials.remove(i);
        }
        else if(i>materials.size()-1)
        {
            System.out.println("There is no customer number "+i);
        }
    }
    public void UpdateMaterial(int i, Material material){
        if (i>=0 && i < materials.size()) {
            materials.set(i,material);
        }
        else if(i>=materials.size())
        {
            System.out.println("There is no material number "+i);
        }
    }
    public void SelectMaterial(int i){
        if (i>=0 && i < materials.size()-1) {
            materials.get(i);
        }
        else if(i>=materials.size())
        {
            System.out.println("There is no material number "+i);
        }
    }
    public Material selectbyname(String title){
        Material material = null;
        for (int i=0;i<materials.size();i++){
            if (materials.get(i).getFilename().equals(title)){
              material=materials.get(i);  
            }
            
        }
        return material;
    }
    public void DisplayMaterial(){
        //customers.forEach(System.out::println);
        for(Material m : materials){
            System.out.println(m.toString());
        }
    }
    public void ClearMaterial(){materials.clear();}

    public void saveMaterialCatalog(String filename)   {

        try {
            //(int id, String filename, String duration, String title, String description, String creator, Date dateOfArchive, int size, String quality)
            PrintWriter printWriter = new PrintWriter(new File(filename));
            for (Material m : materials) {
                if (m instanceof mp3Material) {
                    printWriter.println(m.getId()+","+m.getFilename() + "," + m.getDuration() + "," + m.getTitle()
                            + "," + m.getDescription() + "," + m.getCreator() + "," + m.getDateOfArchive() + "," + m.getSize() + "," + m.getQuality() + ","+"mp3");
                }
                else if(m instanceof mp4Material){
                    printWriter.println(m.getFilename() + "," + m.getDuration() + "," + m.getTitle()
                            + "," + m.getDescription() + "," + m.getCreator() + "," + m.getDateOfArchive() + "," + m.getSize() + "," + m.getQuality() + ","+"mp4");
                }
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be saved");
        }

    }

    public void loadMaterialCatalog(String filename){
        materials.clear();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] words = line.split(",");
                DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy");
                //(int id, String filename, String duration, String title, String description, String creator, Date dateOfArchive, int size, String quality)
                if (words[9].equals("mp3")){
                    Material material = new mp3Material(
                            Integer.parseInt(words[0]),
                            words[1],
                            words[2] ,
                            words[3] ,
                            words[4] ,
                            words[5] ,
                            df.parse(words[6]),
                            Integer.parseInt(words[7]),
                            words[8],
                            words[9]);
                    materials.add(material);
                }
                else if(words[9].equals("mp4")){
                    Material material = new mp4Material(
                            Integer.parseInt(words[0]),
                            words[1],
                            words[2] ,
                            words[3] ,
                            words[4] ,
                            words[5] ,
                            df.parse(words[6]),
                            Integer.parseInt(words[7]),
                            words[8],
                            words[9]);
                    materials.add(material);
                }

            }
        } catch (Exception e) {
        }
    }
    public void countnumber(){
        int mbammount=0;
        System.out.println(materials.size());
        for (int i=0;i<materials.size();i++)
        {
            mbammount+=materials.get(i).getSize();
        }
        System.out.println("Your files total size is: "+mbammount+" mb.");

    }
}
