package Task1;

import java.util.ArrayList;

public class Album {

    String title;
    String artist;
    int year;
    String sales;
    ArrayList<String> tracks;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public void setTracks(ArrayList<String> tracks) {
        this.tracks = tracks;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public String getSales() {
        return sales;
    }

    public ArrayList<String> getTracks() {
        return tracks;
    }
    
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Title: \t\t").append(this.getTitle()).append("\n");
        sb.append("Artist:\t\t").append(this.getArtist()).append("\n");
        sb.append("Year:  \t\t").append(this.getYear()).append("\n");
        sb.append("Sales: \t\t").append(this.getSales()).append("\n");
        sb.append("Tracks:\t\t").append(this.getTracks()).append("\n");
       
        System.out.println("\n");

        return sb.toString();

    }

}
