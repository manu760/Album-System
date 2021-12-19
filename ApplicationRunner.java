
import Task1.Album;
import Task1.LoadData;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationRunner {
    
    public static void printSpace(int len){
        for(int i = 0;i < len;i++)
            System.out.print(" ");
    }
    public static void listAlbums(LoadData data){
        ArrayList<Album> album = data.getTheData();
        int len = album.size();
        
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("| Rank | Title\t\t\t\t\t\t| Artist\t\t\t| Year | Sales |");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for(int i = 0;i < len;i++)
            if (i < 10){
                System.out.print("|    " + (i + 1) + " | " + album.get(i).getTitle());
                printSpace(46 - album.get(i).getTitle().length());
                System.out.print(" | " + album.get(i).getArtist());
                printSpace(29 - album.get(i).getArtist().length());
                System.out.print(" | " + album.get(i).getYear());
                System.out.print(" | " + album.get(i).getSales());
                printSpace(5 - album.get(i).getSales().length());
                System.out.print(" |\n");
            }
            else{
                System.out.print("|   " + (i + 1) + " | " + album.get(i).getTitle());        

                printSpace(46 - album.get(i).getTitle().length());
                System.out.print(" | " + album.get(i).getArtist());
                printSpace(29 - album.get(i).getArtist().length());
                System.out.print(" | " + album.get(i).getYear());
                System.out.print(" | " + album.get(i).getSales());
                printSpace(5 - album.get(i).getSales().length());
                System.out.print(" |\n");
            }
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.print("\n");
    }
    public static void showMenu(){
        System.out.println("List albums.........1");
        System.out.println("Select album........2");
        System.out.println("Search titles.......3");
        System.out.println("Exit................0");
        System.out.print("Enter choices:>");
    }
    public static void selectAlbum(int index,LoadData data){
        System.out.println();
        ArrayList<Album> album = data.getTheData();
        System.out.print("Album title:\t\t\t\t");
        System.out.println(album.get(index).getTitle());
        System.out.print("Artist:\t\t\t");
        System.out.println(album.get(index).getArtist());
        System.out.print("Year of release:\t");
        System.out.println("" + album.get(index).getYear());
        System.out.print("Sales to date:\t\t");
        System.out.println(album.get(index).getSales());
        System.out.println();
        System.out.println("Track list:");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("|No.\t|Title\t\t\t\t\t\t\t\t  |Mins|Secs|");
        System.out.println("-------------------------------------------------------------------------------------");
        ArrayList<String> list = album.get(index).getTracks();
        for(int i = 0;i < list.size();i++){
            String[] temp = list.get(i).split("\\(");
            String time = temp[1].substring(0,temp[1].length() - 1);
            String[] temp1 = time.split(":");
            int min = Integer.parseInt(temp1[0]);
            int sec = Integer.parseInt(temp1[1]);
            System.out.print("|" + (i + 1) + "\t|" + temp[0]);
            printSpace(65 - temp[0].length());
            if (sec < 10)
                System.out.print("|   " + min + "|   " + sec + "|\n");
            else
                System.out.print("|   " + min + "|  " + sec + "|\n");
        }
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.print("\n");
    }
    public static void searchTitle(String title,LoadData data){
        System.out.println();
        ArrayList<Album> album = data.getTheData();
        int len = album.size();
        ArrayList<String> listStr = new ArrayList<String>();
        for(int i = 0;i < len;i++){
            ArrayList<String> list = album.get(i).getTracks();
            for(int j = 0;j < list.size();j++){
                if (list.get(j).toLowerCase().contains(title.toLowerCase())){
                    String str = album.get(i).getArtist() + album.get(i).getTitle();
                    boolean flag = false;
                    for(int k = 0;k < listStr.size();k++){
                        if (listStr.get(k).compareTo(str) == 0){                            
                            flag = true;
                            break;
                        }                        
                    }
                    if (!flag){
                        System.out.println("----");
                        System.out.println("Artist (" + album.get(i).getArtist() + ") Album (" + album.get(i).getTitle() + ")");
                        System.out.println("Matching song title(s):");
                        System.out.println("----");
                        listStr.add(str);
                    }
                    
                    String[] temp = list.get(j).split("\\(");
                    System.out.println("Track " + (j + 1) + ". " + temp[0]);
                }
            }
        }
        System.out.print("\n");
        System.out.print("\n");
    }
    public static void main(String[] args) {
        
        LoadData L1 = new LoadData();
        while(true){
            showMenu();
            String title = "";
            int option = 0,selectId = 0;
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            
            try {
                option = Integer.parseInt(str);
                if (option < 0 || option > 3){
                    System.out.println("You should input integer between 0 and 3");
                    continue;
                }
                    
            } catch (NumberFormatException e) {
                System.out.println("You should input integer");
                continue;
            }            
            
            if (option == 0)
                break;
            switch(option){
                case 1:
                    listAlbums(L1);
                    break;
                case 2:
                    System.out.print("Enter album rank from list [1 - 20] :>");
                    str = scanner.nextLine();                    
                    try {
                        selectId = Integer.parseInt(str);
                        if (selectId < 1 || selectId > 20){
                            System.out.println("You should input integer between 1 and 20");
                            continue;
                        }
                    
                    } catch (NumberFormatException e) {
                        System.out.println("You should input integer");
                        continue;
                    }                         
                    
                    selectAlbum(selectId - 1,L1);
                    break;
                case 3:
                    System.out.print("Enter search word or phrase > ");
                    title = scanner.next();
                    searchTitle(title,L1);
                    break;
            }
        }
    }
    
}
