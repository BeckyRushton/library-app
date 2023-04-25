package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookInitialiser {

    public static void csvToJson() throws IOException, CsvException {
        String csvFilePath = "src/main/resources/books_data.csv";
        String jsonFilePath = "src/main/resources/books.json";


        CSVReader reader = new CSVReaderBuilder(new FileReader(csvFilePath)).withSkipLines(1).build();
        List<String[]> csvData = reader.readAll();


        JSONArray jsonArray = new JSONArray();


        for (String[] row : csvData) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Number", row[0]);
            jsonObject.put("Title", row[1]);
            jsonObject.put("Author", row[2]);
            jsonObject.put("Genre", row[3]);
            jsonObject.put("SubGenre", row[4]);
            jsonObject.put("Publisher", row[5]);
            jsonArray.add(jsonObject);
        }


        try (FileWriter fileWriter = new FileWriter(jsonFilePath)) {
            fileWriter.write(jsonArray.toJSONString());
        }

    }
    public static void init() throws IOException, ParseException {
        String jsonFilePath = "src/main/resources/books.json";

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(jsonFilePath));


        List<Book> books = new ArrayList<>();
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            Book book = new Book();
            book.setNumber((String) jsonObject.get("Number"));
            book.setTitle((String) jsonObject.get("Title"));
            book.setAuthor((String) jsonObject.get("Author"));
            book.setGenre((String) jsonObject.get("Genre"));
            book.setSubGenre((String) jsonObject.get("SubGenre"));
            book.setPublisher((String) jsonObject.get("Publisher"));
            Library.allBooks.add(book);
        }

    }
}
