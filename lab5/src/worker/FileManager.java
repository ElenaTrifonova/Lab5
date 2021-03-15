package worker;

import java.io.*;
import java.util.*;

import collection.Organization;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;


public class FileManager {
    File fileCollection = new File(System.getenv("FilePath"));
    Hashtable<Long, Organization> collection = new Hashtable<>();

    public void loadCollection(String filePath) throws FileNotFoundException {

        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(fileCollection), "UTF-8");
            BufferedReader buffereader = new BufferedReader(reader);
            Gson gson = new Gson();
            System.out.println("Загрузка коллекции из файла " + fileCollection.getAbsolutePath());
            StringBuilder stringBuilder = new StringBuilder();
            String nextString;
            while ((nextString = buffereader.readLine()) != null) {
                stringBuilder.append(nextString);
            }
            Type typeOfCollection = new TypeToken<Hashtable<Long, Organization>>() {
            }.getType();

            try {
                collection = gson.fromJson(stringBuilder.toString(), typeOfCollection); //подаем строку


            } catch (JsonSyntaxException e) {
                System.out.println("Ошибка синтаксиса Json. Файл не может быть загружен.");

            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public boolean  save(Hashtable<Long, Organization> collection) {
        Gson gson = new Gson();
        if (!fileCollection.exists()) {
            System.out.println(("Невозможно сохранить файл. Файл по указанному пути (" + fileCollection.getAbsolutePath() + ") не существует."));
        } else if (!fileCollection.canRead() || !fileCollection.canWrite()) {
            System.out.println("Невозможно сохранить файл. Файл защищён от чтения и(или) записи.");
        } else {

            try{
                System.out.println(fileCollection.getAbsolutePath());
                fileCollection.createNewFile();
                FileWriter fileWriter = new FileWriter(fileCollection);
                String stringColl = gson.toJson(collection);

                fileWriter.write(stringColl, 0, stringColl.length());

                fileWriter.flush();
                fileWriter.close();
                System.out.println("Файл успешно сохранён.");
                return true;
            } catch (Exception ex) {
                System.out.println("При записи файла что-то пошло не так.");
            }
        }
        return false;
    }

    public  Hashtable<Long, Organization> getCollection() {
        return collection;
    }

    public String getFile() {
        return fileCollection.getAbsolutePath();
    }

    @Override
    public String toString() {
        return "Information about collection:\n" +
                "File path:" + fileCollection.getAbsolutePath() + "\n" +
                "Type of collection: " + collection.getClass().toString(); //РАЗОБРАТЬСЯ С ВЫВОДОМ ТИПА КОЛЛЕКЦИИ
    }
}