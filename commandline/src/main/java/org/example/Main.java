package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static List<User> readUsersFromJson(String filename) throws IOException {
        FileIO fileIO = new FileIO(filename);
        String jsonContent = Files.readString(fileIO.filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonContent, new TypeReference<List<User>>() {});;
    }

    public static String generateSqlLine(User user) {
        int id = user.getId();
        String username = user.getUsername().replace("'", "''");
        String first_name = user.getFirst_name().replace("'", "''");
        String last_name = user.getLast_name().replace("'", "''");
        String email = user.getEmail().replace("'", "''");
        String avatar = user.getAvatar().replace("'", "''");
        String password = user.getPassword().replace("'", "''");

        return String.format("INSERT INTO users VALUES(%d,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");",
                id, username, first_name, last_name, email, avatar, password);
    }

    public static void main(String[] args) throws IOException {
        var users = readUsersFromJson("users.json");
        List<String> sqlLines = new ArrayList<>();
        for (User user : users) {
            String sqlLine = generateSqlLine(user);
            sqlLines.add(sqlLine);
        }
        Files.write(Paths.get("db/seeds/users.sql"), sqlLines);
    }
}
