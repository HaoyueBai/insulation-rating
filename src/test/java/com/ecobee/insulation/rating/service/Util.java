package com.ecobee.insulation.rating.service;

import com.ecobee.insulation.rating.model.DataSection;
import com.ecobee.insulation.rating.model.QuerySection;

import java.util.ArrayList;
import java.util.HashMap;

public class Util {



    public static HashMap<String, ArrayList<DataSection>> getProcessedData_Normal(){
        HashMap<String, ArrayList<DataSection>> map = new HashMap<>();
        ArrayList<DataSection> list_1 = new ArrayList<>();
        list_1.add(new DataSection("John Doe","Canada/Ontario/Toronto",1.5));
        list_1.add(new DataSection("Samanta Smith","Canada/Ontario/London",3.7));
        list_1.add(new DataSection("Adam Xin","Canada/British Columbia/Vancouver",2.110));
        list_1.add(new DataSection("Monica Taylor","Canada/Ontario/Toronto",2.110));
        list_1.add(new DataSection("Mohammed Zadeh","Canada/Ontario/Toronto",1.43));
        map.put("Canada",list_1);
        ArrayList<DataSection> list_2 = new ArrayList<>();
        list_2.add(new DataSection("Alicia Yazzie","US/Arizona/Phoenix",5.532));
        map.put("US",list_2);
        return map;
    }




    public static HashMap<String,Double> getNameToRvalue_Normal(){
        HashMap<String,Double> nameToRvalue = new HashMap<>();
        nameToRvalue.put("John Doe",1.5);
        nameToRvalue.put("Samanta Smith",3.7);
        nameToRvalue.put("Adam Xin",2.110);
        nameToRvalue.put("Monica Taylor",2.110);
        nameToRvalue.put("Mohammed Zadeh",1.43);
        nameToRvalue.put("Alicia Yazzie",5.532);
     return nameToRvalue;
    }

    public static ArrayList<QuerySection> getQueries_Normal(){
        ArrayList<QuerySection> list = new ArrayList<>();
        list.add(new QuerySection("John Doe","Canada"));
        list.add(new QuerySection("John Doe","Canada/Ontario"));
        list.add(new QuerySection("Alicia Yazzie","US/Arizona"));
        return list;
    }

    public static String outPut_Normal = "\"John Doe\" \"Canada\" 4\n" +
            "\"John Doe\" \"Canada/Ontario\" 5\n" +
            "\"Alicia Yazzie\" \"US/Arizona\" 10\n";



    public static ArrayList<QuerySection> getQueries_invalidName(){
        ArrayList<QuerySection> list = new ArrayList<>();
        list.add(new QuerySection("John Doe 2","Canada"));
        list.add(new QuerySection("John Doe","Canada/Ontario"));
        list.add(new QuerySection("Alicia Yazzie","US/Arizona"));
        return list;
    }

    public static String outPut_invalidName = "\"John Doe 2\" \"Canada\" -1\n" +
            "\"John Doe\" \"Canada/Ontario\" 5\n" +
            "\"Alicia Yazzie\" \"US/Arizona\" 10\n";


    public static ArrayList<QuerySection> getQueries_worstBest(){
        ArrayList<QuerySection> list = new ArrayList<>();
        list.add(new QuerySection("Mohammed Zadeh","Canada"));
        list.add(new QuerySection("Alicia Yazzie","US/Arizona"));
        return list;
    }

    public static String outPut_worstBest = "\"Mohammed Zadeh\" \"Canada\" 1\n" +
            "\"Alicia Yazzie\" \"US/Arizona\" 10\n";

    public static ArrayList<QuerySection> getQueries_sameRvalue() {

        ArrayList<QuerySection> list = new ArrayList<>();
        list.add(new QuerySection("Adam Xin","Canada"));
        list.add(new QuerySection("Monica Taylor","Canada"));
        return list;
    }


    public static String outPut_sameRvalue = "\"Adam Xin\" \"Canada\" 8\n" +
            "\"Monica Taylor\" \"Canada\" 8\n";


    public static ArrayList<QuerySection> getQueries_invalidProvince(){
        ArrayList<QuerySection> list = new ArrayList<>();
        list.add(new QuerySection("John Doe","Canada/Yukon"));
        return list;
    }

    public static String outPut_invalidProvince = "\"John Doe\" \"Canada/Yukon\" -1\n";

    public static ArrayList<QuerySection> getQueries_invalidCountry(){
        ArrayList<QuerySection> list = new ArrayList<>();
        list.add(new QuerySection("John Doe","UK"));
        return list;
    }

    public static String outPut_invalidCountry = "\"John Doe\" \"UK\" -1\n";


    public static ArrayList<QuerySection> getQueries_invalidCity(){
        ArrayList<QuerySection> list = new ArrayList<>();
        list.add(new QuerySection("John Doe","Canada/Ontario/Hamilton"));
        return list;
    }

    public static String outPut_invalidCity = "\"John Doe\" \"Canada/Ontario/Hamilton\" -1\n";



    public static HashMap<String, ArrayList<DataSection>> getProcessedData_allSame(){
        HashMap<String, ArrayList<DataSection>> map = new HashMap<>();
        ArrayList<DataSection> list_1 = new ArrayList<>();
        list_1.add(new DataSection("John Doe","Canada/Ontario/Toronto",1.5));
        list_1.add(new DataSection("Samanta Smith","Canada/Ontario/London",1.5));
        list_1.add(new DataSection("Adam Xin","Canada/British Columbia/Vancouver",1.5));
        list_1.add(new DataSection("Monica Taylor","Canada/Ontario/Toronto",1.5));
        list_1.add(new DataSection("Mohammed Zadeh","Canada/Ontario/Toronto",1.5));
        map.put("Canada",list_1);
        ArrayList<DataSection> list_2 = new ArrayList<>();
        list_2.add(new DataSection("Alicia Yazzie","US/Arizona/Phoenix",1.5));
        map.put("US",list_2);
        return map;
    }


    public static HashMap<String,Double> getNameToRvalue_allSame(){
        HashMap<String,Double> nameToRvalue = new HashMap<>();
        nameToRvalue.put("John Doe",1.5);
        nameToRvalue.put("Samanta Smith",1.5);
        nameToRvalue.put("Adam Xin",1.5);
        nameToRvalue.put("Monica Taylor",1.5);
        nameToRvalue.put("Mohammed Zadeh",1.5);
        nameToRvalue.put("Alicia Yazzie",1.5);
        return nameToRvalue;
    }

    public static ArrayList<QuerySection> getQueries_allSame(){
        ArrayList<QuerySection> list = new ArrayList<>();
        list.add(new QuerySection("John Doe","Canada"));
        list.add(new QuerySection("John Doe","Canada/Ontario"));
        list.add(new QuerySection("Monica Taylor","Canada/Ontario"));
        list.add(new QuerySection("Alicia Yazzie","US/Arizona"));
        return list;
    }

    public static String outPut_allSame = "\"John Doe\" \"Canada\" 10\n" +
            "\"John Doe\" \"Canada/Ontario\" 10\n" +
            "\"Monica Taylor\" \"Canada/Ontario\" 10\n" +
            "\"Alicia Yazzie\" \"US/Arizona\" 10\n";




}
