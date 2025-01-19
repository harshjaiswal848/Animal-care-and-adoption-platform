import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalCareDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/animal_care_db";
    private static final String USER = "root";
    private static final String PASSWORD = "W7301@jqir#";

    // Utility method to get database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // --- User Management Methods ---
    public boolean registerUser(User user) {
        String sql = "INSERT INTO users (username, password, email, phone) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPhone());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // --- Animal Management Methods ---
    public List<Animal> getAllAnimals() {
        String sql = "SELECT * FROM animals";
        List<Animal> animals = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Animal animal = new Animal(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getString("breed"),
                        rs.getInt("age"),
                        rs.getString("status")
                );
                animals.add(animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animals;
    }

    public boolean addAnimal(Animal animal) {
        String sql = "INSERT INTO animals (name, type, breed, age, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, animal.getName());
            pstmt.setString(2, animal.getType());
            pstmt.setString(3, animal.getBreed());
            pstmt.setInt(4, animal.getAge());
            pstmt.setString(5, animal.getStatus());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateAnimalStatus(int animalId, String status) {
        String sql = "UPDATE animals SET status = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, status);
            pstmt.setInt(2, animalId);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // --- Adoption Management Methods ---
    public boolean recordAdoption(Adoption adoption) {
        String sql = "INSERT INTO adoptions (user_id, animal_id, adoption_date) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, adoption.getUserId());
            pstmt.setInt(2, adoption.getAnimalId());
            pstmt.setDate(3, Date.valueOf(adoption.getAdoptionDate()));

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Adoption> getAdoptionsByUserId(int userId) {
        String sql = "SELECT * FROM adoptions WHERE user_id = ?";
        List<Adoption> adoptions = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Adoption adoption = new Adoption(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("animal_id"),
                        rs.getDate("adoption_date").toLocalDate()
                );
                adoptions.add(adoption);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adoptions;
    }
}
