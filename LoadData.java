package Task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadData {

    public ArrayList<Album> albumData = new ArrayList<>();

    public LoadData() {
        load();
    }

    public void load() {

        String filePath = System.getProperty("user.dir") + File.separator + "albums.txt";

        Scanner input = null;
        try {
            input = new Scanner(new File(filePath));
            int index = 0;
            while (input.hasNext()) {
                index++;
                String firstLine = input.nextLine();
                String[] sub = firstLine.split(":");
                index = Integer.parseInt(sub[0]);
                String title = sub[1];
                String artist = sub[2];
                int year = Integer.parseInt(sub[3]);
                String sales = sub[4];
                ArrayList<String> list = new ArrayList<String>();
                while (true) {
                    String line = input.nextLine();
                    if (line.contains("---------")) {
                        break;
                    }
                    list.add(line);
                }
                albumData.add(new Album());
                albumData.get(index - 1).setTitle(title);
                albumData.get(index - 1).setArtist(artist);
                albumData.get(index - 1).setYear(year);
                albumData.get(index - 1).setSales(sales);
                albumData.get(index - 1).setTracks(list);
                
                
                

            }

        } catch (FileNotFoundException fnf) {
            System.out.println("File not found");
            System.exit(0);

        }

    }

    public ArrayList<Album> getTheData() {
        return albumData;

    }
}
