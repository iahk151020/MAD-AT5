package com.example.mad;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class FileHelper <T> {

    private String fileName;
    Context context;
    public FileHelper(String fileName, Context context) {
        this.fileName = fileName;
        this.context = context;
    }

    void insertToFile(T obj) {
        String data;
            try {

                if (obj instanceof SinhVien) data = parseStudentToString((SinhVien)obj);
                else data = parseClassToString((Lop) obj);
                Log.i("DATA", data);

                FileOutputStream fos = context.openFileOutput("classes.txt",  context.MODE_APPEND);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
//                osw.write("");
                osw.append(data);
                osw.close();
                Log.i("INSERT", "OK");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    String parseStudentToString(SinhVien obj) {
        String data = "";
        data += obj.getMaSinhVien() + "" + "," +
                obj.getTen() + "," +
                obj.getNamSinh() + "" + "," +
                obj.getNamHoc() + "" + "," +
                obj.getQueQuan();
        return data;
    }

    String parseClassToString(Lop obj) {
        String data = obj.getMaLop() + "" + ","
                + obj.getTenLop() + ","
                + obj.getMoTa() + "\n";
        return data;
    }

    List<SinhVien> getAllStudents() throws IOException {
        List<SinhVien> students = new ArrayList<>();
        InputStream is = context.openFileInput(fileName);

        if (is != null) {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String row;

            while((row = br.readLine()) != null) {
                Log.i("READ DATA", row);
                String[] svData = row.split(",");
                students.add(new SinhVien(
                        Integer.parseInt( svData[0]),
                        Integer.parseInt(svData[2]),
                        Integer.parseInt(svData[3]),
                        svData[1],
                        svData[4]
                ));
            }
        }

        return students;
    }

    List<Lop> getAllClasses() throws IOException {
        List<Lop> classes = new ArrayList<>();
        FileInputStream fis = context.openFileInput("classes.txt");


            InputStreamReader ins = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(ins);
            String row = br.readLine();

            while (row != null) {

                Log.i("READ DATA", row);
                String[] svData = row.split(",");
                classes.add(new Lop(
                        Integer.parseInt(svData[0]),
                        svData[1],
                        svData[2]
                ));
                row = br.readLine();
            }


        return classes;
    }

    int genStudentId() throws IOException {
        return getAllStudents().size() + 1;
    }



}
