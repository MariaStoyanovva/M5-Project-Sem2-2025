import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

public class helper {
    public static void main(String[] args) {
        ArrayList<movie> movieArrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

    }

    public static void addMovie(ArrayList<movie> movies){
        Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Title:");
            String enterTitle=scanner.nextLine();
            System.out.println("Enter Genre:");
            String enterGenre=scanner.nextLine();
            movie object = new movie(enterTitle,enterGenre);
            movies.add(object);
    }

    public static void printMovies(ArrayList<movie> movies){
        for(int i=0;i<movies.size();i++){
            movie currentMovie = movies.get(i);
            System.out.println(currentMovie.getTitle() + " " + currentMovie.getGenre());
        }
    }

    public static void printTotal(ArrayList<movie> movies){
        System.out.println("Total number of movies: " + movies.size() );
    }

    public static void sortMovies(ArrayList<movie> movies){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. A-Z");
        System.out.println("2. Z-A");
        System.out.println("3. Genre");
        int num = scanner.nextInt();

        if(num==1){
            movies.sort(Comparator.comparing(movie::getTitle)); // sort A-Z (by title)
        } else if (num == 2) {
            movies.sort(Comparator.comparing(movie::getTitle).reversed()); // sort Z-A (by title)
        } else if (num == 3) {
            movies.sort(Comparator.comparing(movie::getGenre)); // sort by genre A-Z
        }
    }

    public static void searchMovie(ArrayList<movie> movies){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which movie do you want?");
        String searched = scanner.nextLine();
        String compressedSearched=searched.replaceAll("\\s", "");
        for(movie element: movies){
            String compressedElement=element.getTitle().replaceAll("\\s", "");
            if((compressedElement.toLowerCase()).contains(compressedSearched.toLowerCase())){
                System.out.println(element.getTitle());
            }
        }
    }


}


class movie{
    private String title;
    private String genre;

    public movie(String title, String genre){
        this.title=title;
        this.genre=genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
}
