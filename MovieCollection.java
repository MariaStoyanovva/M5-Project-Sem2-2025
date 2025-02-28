import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MovieCollection {
    public static void main(String[] args) {

        //  ArrayList<Movie> moviesArrayList = new ArrayList<>();

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
        });//make the search textfield have a hint message
        JButton enter = new JButton("Enter");

        one.add(sortMovies);
        one.add(search);
        one.add(enter);


        //panel 2
        JPanel two = new JPanel();

        JTextField title = new JTextField(20);
        String[] typesOfGenres = {"Comedy", "Romance", "Horror", "Fantasy", "Kids"};
        JComboBox genre = new JComboBox(typesOfGenres);
        JButton addMovie = new JButton("ADD");

        two.add(title);
        two.add(genre);
        two.add(addMovie);

        //panel 3
        JPanel three = new JPanel();
        JButton totalMovies = new JButton("Total");
        JLabel numberOfMovies = new JLabel("bla bla");

        three.add(totalMovies);
        three.add(numberOfMovies);

        //panel 4 - TABLE PANEL
        JPanel four = new JPanel(new BorderLayout());
        String[] columnTitles = {"Title", "Genre"};

        //creating dynamic table
        DefaultTableModel model = new DefaultTableModel(columnTitles, 1);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        //add elements to the panel
        four.add(scrollPane, BorderLayout.CENTER);

        //controls and buttons on top
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new GridLayout(3, 1)); // Stack panels in a grid
        containerPanel.add(one);
        containerPanel.add(two);
        containerPanel.add(three);

        //add panels to the frame with BorderLayout
        frame.add(containerPanel, BorderLayout.NORTH); // controls and buttons on Top
        frame.add(four, BorderLayout.CENTER); // table in Center


        //make frame visible
        frame.setVisible(true);

        //addMovie button
        addMovie.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                model.addRow(new Object[]{ "", "Option 1" });
            }
        });
    }
}
        /*
        //WHAT EACH ELEMENT/BUTTON DOES
        //addMovie button
        addMovie.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                model.addRow(new Object[]{ "", "Option 1" });
            }
        });

        //sortMovies dropdown
        sortMovies.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(sortMovies.getSelectedItem().toString()==("A-Z")){
                    moviesArrayList.sort(Comparator.naturalOrder());
                }
                else if(sortMovies.getSelectedItem().toString()==("Z-A")){
                    moviesArrayList.sort(Comparator.reverseOrder());
                }
            }
        });





    }

   public void addNewMovie(ArrayList<Movie> moviesList){


    }
}
*/

class Movie{
    private String title;
    private String genre;

    public Movie(String title){
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

/*
          MOVIE COLLECTION MANAGER
[add movie][sort(dropdown A-Z/genre)][Total]
 */
