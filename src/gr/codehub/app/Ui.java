package gr.codehub.app;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ui {
    public void mainloop(){
        int selection=5;
        int index;
        String searcher;
        String filename;
        materialCatalog catalog = new materialCatalog();
        do{
            System.out.println("1. Create material.   2.Delete material.  3.Update material.  4.Search material. 5. View materials   6.Save materials   7.Load materials 8.Count your files and the size.  0.Exit.");
            Scanner scanner = new Scanner(System.in);
            try{
                selection = scanner.nextInt();
            }
            catch(Exception e){
                System.out.println("Not a number.");
            }
            switch (selection){
                case 1:
                    catalog.addMaterial(createMaterial(catalog));
                    break;
                case 2:
                    System.out.println("Give an index to remove");
                    index= scanner.nextInt();
                    catalog.RemoveMaterial(index);
                    break;
                case 3:
                    System.out.println("Give an index to update");
                    index= scanner.nextInt();
                    catalog.UpdateMaterial(index,createMaterial(catalog));

                    break;
                case 4:
                    System.out.println("Give an index or a title to search");
                    searcher= scanner.next();
                    int x=0;
                    try {
                        index =Integer.parseInt(searcher);
                        catalog.SelectMaterial(index);
                    }
                    catch(Exception e){
                        x=1;
                    }
                    try{
                        if (x==1) {
                            Material material = catalog.selectbyname(searcher);
                            if (!material.equals(null)) {
                                System.out.println(material.toString());
                            }
                        }
                    }
                    catch(Exception e){
                        System.out.println("Song not found.");
                        }

                    break;
                case 5:
                    catalog.DisplayMaterial();
                    break;
                case 6:
                    System.out.println("Give a file name 'example.txt'");
                    filename=scanner.next();
                    catalog.saveMaterialCatalog(filename);
                    break;
                case 7:
                    System.out.println("Which file do you want to load 'example.txt'");
                    filename=scanner.next();
                    catalog.loadMaterialCatalog(filename);
                    break;
                case 8:
                    catalog.countnumber();
                    break;
                case 0:
                    System.out.println("Bye bye");
                    break;
            }

        }while (selection!=0);
    }

    public Material createMaterial(materialCatalog catalog){
        Scanner scanner = new Scanner(System.in);
        String filename,filetype,duration,title,description,creator,dateOfArchivestr,quality;
        int size,id;
        Date dateofArchive;
        int customerscount = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date dateofbirth=new Date();
        Material material = new Material();
        System.out.println("Give filename:");
        filename = scanner.nextLine();
        System.out.println("Give filetype (mp3,mp4):");
        filetype = scanner.nextLine();
        System.out.println("Give file duration:");
        duration = scanner.nextLine();
        System.out.println("Give file title:");
        title = scanner.nextLine();
        System.out.println("Give description title:");
        description = scanner.nextLine();
        System.out.println("Give file creator name:");
        creator = scanner.nextLine();
        System.out.println("Give Archives creation date (dd-MM-yyyy HH:mm):");
        dateOfArchivestr = scanner.nextLine();
        try {
            dateofArchive = sdf.parse(dateOfArchivestr);
        } catch (Exception e) {
            System.out.println("Wrong Date Format!");
            dateofArchive=null;
        }
        System.out.println("Give file quality:");
        quality = scanner.nextLine();
        System.out.println("Give file size in Megabytes");
        size = scanner.nextInt();
        id= catalog.GetSize() + 1;
        //(int id, String filename, String duration, String title, String description, String creator, Date dateOfArchive, int size, String quality)
        switch (filetype){
            case "mp3":
                material = new mp3Material(id,filename, duration, title,description,creator,dateofArchive,size,quality,"mp3");
                System.out.println("Created mp3 file named '"+filename+".mp3'");
                return material;
            case "mp4":
                material = new mp4Material(id,filename, duration, title,description,creator,dateofArchive,size,quality,"mp4");
                return material;
            default:
                System.out.println("failed to create");
                return null;
        }


    }
}
