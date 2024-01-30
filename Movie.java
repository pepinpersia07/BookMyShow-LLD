public class Movie {
    private String name;
    private  float ratings = (float) 0.0f;
    private Language language;
    private Genre genre;
    public Movie() {
    }
    public Movie(String name, Language language, Genre genre) {
        this.name = name;
        this.language = language;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    // Method to update movie ratings
    public void updateRatings(float newRating) {
        if (newRating >= 0 && newRating <= 10) {
            // Update the ratings based on the new rating provided
            this.ratings = (this.ratings + newRating) / 2;  // You can implement your own logic here

            System.out.println("Movie ratings updated successfully.");
        } else {
            System.out.println("Invalid rating provided. Please provide a rating between 0 and 10.");
        }
    }

}
