import java.io.*;
import java.util.*;

public class Movie {
    static File file = new File("src/movies.txt");
    private int movieId;
    private int numberofViewers;
    private double rating;
    private int releaseYear;
    private String movieName;


    public Movie(){

    }
    public Movie(int movieId, int numberofViewers, double rating, int releaseYear, String movieName) {

        this.movieId = movieId;
        this.numberofViewers = numberofViewers;
        this.rating = rating;
       this.releaseYear = releaseYear;
        this.movieName = movieName;
    }
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        movieId = movieId;
    }
    public int getNumberofViewers() {
        return numberofViewers;
    }
    public void setNumberofViewers(int numberofViewers) {
        numberofViewers = numberofViewers;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        releaseYear = releaseYear;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        movieName = movieName;
    }
    @Override
    public String toString() {
        return movieId + " " + numberofViewers + " " + rating + " " + releaseYear + " " + movieName + '\n';
    }

    public static void readData(Movie[] movies) throws FileNotFoundException {
        Scanner input = new Scanner(file);

        int i = 0;
        while (input.hasNext()) {
            int movieId = input.nextInt();
            int numberofViewers = input.nextInt();
            double rating = input.nextDouble();
            int releaseYear = input.nextInt();
            String movieName = input.nextLine();
            movies[i] = new Movie(movieId,numberofViewers,rating,releaseYear, movieName);
            i++;
        }
        input.close();
    }
    public static void readData(List<Movie> movies) throws FileNotFoundException {
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            int movieId = input.nextInt();
            int numberofViewers = input.nextInt();
            double rating = input.nextDouble();
            int releaseYear = input.nextInt();
            String movieName = input.nextLine();
            movies.add (new Movie(movieId,numberofViewers,rating,releaseYear, movieName));
        }
        input.close();
    }

    public static void search(Movie[] movies, double rating){
        for (Movie movie: movies) {
            if (movie.getRating() == rating){
                System.out.println(movie);
            }
        }
    }
    public static void search(List <Movie> movies, int releaseYear, double rating){
        for (Movie movie: movies) {
            if (movie.getReleaseYear() == releaseYear && movie.getRating() == rating){
                System.out.println(movie);
            }
        }
    }

    public static void compareMovies(Movie[] movies){
        Arrays.sort(movies, Comparator.comparing(Movie::getRating));
        for (Movie m : movies){
            System.out.println(m);
        }
    }

    public static void compareMovies(List<Movie> movies){
        movies.sort(Comparator.comparing(Movie::getReleaseYear).thenComparing(Movie::getRating));
        movies.forEach(System.out::println);
    }

    public static  void main(String[] args) throws FileNotFoundException {
      Movie[] filmArr = new Movie[100];
      readData(filmArr);
     //search(filmArr, 9.0);
      compareMovies(filmArr);

      //List<Movie> filmList = new ArrayList<>();
        //readData(filmList);
        //search(filmList, 1991,  9.0);
        //compareMovies(filmList);

    }


}

