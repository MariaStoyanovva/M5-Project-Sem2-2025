import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Scanner;

public class MovieCollection {
    public static void main(String[] args) {

        ArrayList<Movie> moviesArrayList = new ArrayList<>();

        //create frame
        JFrame frame = new JFrame("MOVIE COLLECTION MANAGER");
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panel 1
        JPanel one = new JPanel(new FlowLayout());

        String[] typesOfSorting = {"A-Z", "Z-A", "By Genre"};
        JComboBox sortMovies = new JComboBox(typesOfSorting);
        JTextField search = new JTextField("Search...",20);
        search.setForeground(Color.GRAY);

        search.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                if (search.getText().equals("Search...")) {
                    search.setText("");
                    search.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (search.getText().isEmpty()) {
                    search.setText("Search...");
                    search.setForeground(Color.GRAY);
                }
            }
        });  //make the search textfield have a hint message

        JButton enter = new JButton("Enter");

        one.add(sortMovies);
        one.add(search);
        one.add(enter);


        //panel 2
        JPanel two = new JPanel();

        JTextField title = new JTextField(20);
        String[] typesOfGenres = {"Comedy", "Romance", "Horror", "Fantasy", "Kids"};  //info for the dropdown menu of genres
        JComboBox genre = new JComboBox(typesOfGenres);
        JButton addMovie = new JButton("ADD");

        two.add(title);
        two.add(genre);
        two.add(addMovie);


        //panel 3
        JPanel three = new JPanel();
        JButton totalMovies = new JButton("Total");
        JLabel numberOfMovies = new JLabel("0");

        three.add(totalMovies);
        three.add(numberOfMovies);

        //panel 4 - TABLE PANEL
        JPanel four = new JPanel(new BorderLayout());
        String[] columnTitles = {"Title", "Genre"};

        //creating dynamic table
        DefaultTableModel model = new DefaultTableModel(columnTitles, 1);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        four.add(scrollPane, BorderLayout.CENTER);

        //set up how the frame looks
        //controls and buttons on top
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new GridLayout(3, 1)); // stack the panels in the container panel in a grid
        containerPanel.add(one);
        containerPanel.add(two);
        containerPanel.add(three);

        //add panels to the frame with BorderLayout
        frame.add(containerPanel, BorderLayout.NORTH); // controls and buttons on top
        frame.add(four, BorderLayout.CENTER); // table in center


        //make frame visible
        frame.setVisible(true);

        //addMovie button  -  LOOK AT PANEL 2
        addMovie.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String infoForColumnOne = title.getText();
                String infoForColumnTwo = (String)genre.getSelectedItem();
                Movie currentObject = new Movie(infoForColumnOne, infoForColumnTwo); //create a Movie object with title and genre
                moviesArrayList.add(currentObject); // add the object to the arraylist

                model.addRow(new Object[]{ infoForColumnOne, infoForColumnTwo });  //adding a row
            }
        });

        //totalMovies button  -  LOOK AT PANEL 3
        totalMovies.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String numberForLabel = Integer.toString(moviesArrayList.size());
                numberOfMovies.setText(numberForLabel);
            }
        });

        //search and enter button  -  LOOK AT PANEL 1  - highlights searched title
        enter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String titleToLookFor = search.getText();
                titleToLookFor=titleToLookFor.replaceAll("\\s", "");  //remove all spaces to eliminate human error (in the entered String)
                for(Movie element: moviesArrayList){
                    String compressedElement=element.getTitle().replaceAll("\\s", "");  //remove all spaces to eliminate human error (in the title)
                    if((compressedElement.toLowerCase()).contains(titleToLookFor.toLowerCase())){
                        for(int i=0; i<table.getRowCount(); i++){  //looping through all rows
                            if(table.getModel().getValueAt(i,0).equals("STRING_TO_SEARCH")){  //checking only the 0-index row because that's where the titles are
                                System.out.println(table.getModel().getValueAt(i,0)); //Print if found string
                                (table(i,0)).setBackground(Color.WHITE);;
                            }
                        }
                    }
                }
            }
        });


    }


/*

    public static void sortMovies(ArrayList<Movie> movies){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. A-Z");
        System.out.println("2. Z-A");
        System.out.println("3. Genre");
        int num = scanner.nextInt();

        if(num==1){
            movies.sort(Comparator.comparing(Movie::getTitle)); // sort A-Z (by title)
        } else if (num == 2) {
            movies.sort(Comparator.comparing(Movie::getTitle).reversed()); // sort Z-A (by title)
        } else if (num == 3) {
            movies.sort(Comparator.comparing(Movie::getGenre)); // sort by genre A-Z
        }
    }

    public static void searchMovie(ArrayList<Movie> movies){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which movie do you want?");
        String searched = scanner.nextLine();
        String compressedSearched=searched.replaceAll("\\s", "");
        for(Movie element: movies){
            String compressedElement=element.getTitle().replaceAll("\\s", "");
            if((compressedElement.toLowerCase()).contains(compressedSearched.toLowerCase())){
                System.out.println(element.getTitle());
            }
        }
    }
*/


}


class Movie{
    private String title;
    private String genre;

    public Movie(String title, String genre){
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
