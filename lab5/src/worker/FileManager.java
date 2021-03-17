package worker;

import java.io.*;
import java.util.*;

import collection.Organization;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Class that works with file and collection
 */
public class FileManager {
    File fileCollection = new File(System.getenv("FilePath"));
    Hashtable<Long, Organization> collection = new Hashtable<>();

    /**
     * method that loads collection from file
     * @param filePath
     * @throws FileNotFoundException
     */
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

    /**
     * method that saves collection in file
     * @param collection - hashtable
     */
    public void  save(Hashtable<Long, Organization> collection) {
        Gson gson = new Gson();
        if (!fileCollection.exists()) {
            System.out.println(("Невозможно сохранить файл. Файл по указанному пути (" + fileCollection.getAbsolutePath() + ") не существует."));
        } else if (!fileCollection.canRead() || !fileCollection.canWrite()) {
            System.out.println("Невозможно сохранить файл. Файл защищён от чтения и(или) записи.");
        } else {

            try{
                System.out.println(fileCollection.getAbsolutePath());

                FileWriter fileWriter = new FileWriter(fileCollection);
                String stringColl = gson.toJson(collection);

                fileWriter.write(stringColl, 0, stringColl.length());

                fileWriter.flush();
                fileWriter.close();
                System.out.println("Файл успешно сохранён.");

            } catch (Exception ex) {
                System.out.println("При записи файла что-то пошло не так.");
            }
        }

    }

    public  Hashtable<Long, Organization> getCollection() {
        return collection;
    }

    public String getFile() {
        return fileCollection.getAbsolutePath();
    }

    /**
     * method that sorts collection
     * @param collection - hashtable
     */
    public void sort(Hashtable<Long, Organization> collection){
        List<Long> sortedKeys = Collections.list(collection.keys());
        Collections.sort(sortedKeys);
        Iterator<Long> iterator = sortedKeys.iterator();

        Hashtable<Long, Organization> collection_new = new Hashtable<>();
        while(iterator.hasNext()){
            Long element =iterator.next();

            collection_new.put(element, collection.get(element));

        }

        this.collection = collection_new;
    }

    @Override
    public String toString() {
        return "Information about collection:\n" +
                "File path:" + fileCollection.getAbsolutePath() + "\n" +
                "Type of collection: " + collection.getClass().toString();
    }
}