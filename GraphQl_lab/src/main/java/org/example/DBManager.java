package org.example;

import org.example.component.Column;
import org.example.component.Database;
import org.example.component.Row;
import org.example.component.Table;
import org.example.component.column.*;

public class DBManager {

  private static DBManager instance;

  private DBManager() {
  }

  public static DBManager getInstance() {
    if (instance == null) {
      instance = new DBManager();
      database = new Database("DB");
    }
    return instance;
  }



  public static Database database;

  public static void populateTable() {
    Table table = new Table("testTable" + database.tables.size());
    table.addColumn(new TypeInteger("column1"));
    table.addColumn(new TypeReal("column2"));
    table.addColumn(new TypeString("column3"));
    table.addColumn(new TypeChar("column4"));
    table.addColumn(new TypeHTML("column5"));
    table.addColumn(new TypeStringInvl("column6"));
    Row row1 = new Row();
    row1.values.add("10");
    row1.values.add("10.0");
    row1.values.add("10");
    row1.values.add("1");
    row1.values.add("hehe.html");
    row1.values.add("hehe-hihi");
    table.addRow(row1);
    Row row2 = new Row();
    row2.values.add("15");
    row2.values.add("15.0");
    row2.values.add("15");
    row2.values.add("3");
    row2.values.add("hehe.html");
    row2.values.add("hehe-hihi");
    table.addRow(row2);
    database.addTable(table);

    Table table2 = new Table("testTable" + database.tables.size());
    table2.addColumn(new TypeInteger("column1"));
    table2.addColumn(new TypeReal("column2"));
    table2.addColumn(new TypeString("column3"));
    table2.addColumn(new TypeChar("column4"));
    table2.addColumn(new TypeHTML("column5"));
    table2.addColumn(new TypeStringInvl("column6"));
    Row row12 = new Row();
    row12.values.add("10");
    row12.values.add("10.0");
    row12.values.add("10");
    row12.values.add("1");
    row12.values.add("hehe.html");
    row12.values.add("hehe-hihi");
    table2.addRow(row12);
    Row row22 = new Row();
    row22.values.add("15");
    row22.values.add("15.0");
    row22.values.add("15");
    row22.values.add("3");
    row22.values.add("hehe.html");
    row22.values.add("hehe-hihi");
    table2.addRow(row22);
    database.addTable(table2);

    database.addTable(table);
    database.addTable(table2);
  }

  public void deleteRow(int tableIndex, int rowIndex){

    if (rowIndex != -1) {
      database.tables.get(tableIndex).deleteRow(rowIndex);
    }
  }

  public static Boolean addColumn(int tableIndex, String columnName, TypeColumn typeColumn) {
    if (columnName != null && !columnName.isEmpty()) {
      if (tableIndex != -1) {

        switch (typeColumn) {
          case INT -> {
            Column columnInt = new TypeInteger(columnName);
            database.tables.get(tableIndex).addColumn(columnInt);
          }
          case REAL -> {
            Column columnReal = new TypeReal(columnName);
            database.tables.get(tableIndex).addColumn(columnReal);
          }
          case STRING -> {
            Column columnStr = new TypeString(columnName);
            database.tables.get(tableIndex).addColumn(columnStr);
          }
          case CHAR -> {
            Column columnChar = new TypeChar(columnName);
            database.tables.get(tableIndex).addColumn(columnChar);
          }
          case HTML -> {
            Column typeHTML = new TypeHTML(columnName);
            database.tables.get(tableIndex).addColumn(typeHTML);
          }
          case STRINGINVL -> {
            Column typeStringInvl = new TypeStringInvl(columnName);
            database.tables.get(tableIndex).addColumn(typeStringInvl);
          }
        }
        for (Row row : database.tables.get(tableIndex).rows) {
          row.values.add("");
        }
        return true;
      }
      else {
        return false;
      }
    }
    else {
      return false;
    }
  }

  public static void addTable(String name){
    if (name != null && !name.isEmpty()) {
      Table table = new Table(name);
      database.addTable(table);
    }
  }

  public static void addRow(int tableIndex, Row row){

    if (tableIndex != -1) {
      database.tables.get(tableIndex).addRow(row);
      for (int i = row.values.size(); i < database.tables.get(tableIndex).columns.size(); i++){
        row.values.add("");
      }
    }
  }

  public static boolean changeColumnName(int tableIndex, int columnIndex, String newName){
    database.tables.get(tableIndex).columns.get(columnIndex).setName(newName);
    return true;
  }
}
