package ua.edu.sumdu.j2se.radchenko.tasks.view;

import ua.edu.sumdu.j2se.radchenko.tasks.controller.Controller;
import ua.edu.sumdu.j2se.radchenko.tasks.controller.Errors;
import ua.edu.sumdu.j2se.radchenko.tasks.model.AbstractTaskList;
import ua.edu.sumdu.j2se.radchenko.tasks.model.Task;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ChangeTaskView implements View, Action{

    @Override
    public int chosenAction() {
        System.out.println("Choose option");
        System.out.println("1 - chose task by id, 2 - activated/disable task by id, 3 - go back to manu");
        return consoleEntry();
    }

    @Override
    public int printInfo(AbstractTaskList taskList) {
        return Controller.TASK_CHANGE;
    }

    public int repTask(){
        System.out.println("Choose option");
        System.out.println("1 - change name, 2 - change start,end time and interval, 3 - go back to manu");
        return consoleEntry();
    }

    public int nonRepTask(){
        System.out.println("Choose option");
        System.out.println("1 - change name, 2 - change time, 3 - go back to manu");
        return consoleEntry();
    }

    public void printCurrentName(Task task){
        System.out.println("Current name: " + task.getTitle());
    }

    public void printCurrentStartTime(Task task){
        System.out.println("Current start time: " + task.getStartTime());
    }

    public void printCurrentEndTime(Task task){
        System.out.println("Current end time: " + task.getEndTime());
    }

    public void printCurrentInterval(Task task){
        System.out.println("Current interval: " + task.getRepeatInterval());
    }

    public void printCurrentTime(Task task){
        System.out.println("Current time: " + task.getTime());
    }

    public String newTaskName(){
        System.out.println("Type new name: ");
        return consoleStrungEntry();
    }

    public int choseTaskActive(){
        System.out.println("1 - true, 2 - false: ");
        return consoleEntry();
    }

    public LocalDateTime newTaskTime(){
        System.out.println("Type new time (example yyyy-MM-dd HH:mm = 2021-12-13 12:30): ");
        return stringToTime();
    }

    public LocalDateTime newTaskStartTime(){
        System.out.println("Type new start time (example yyyy-MM-dd HH:mm = 2021-12-13 12:30): ");
        return stringToTime();
    }

    public LocalDateTime newTaskEndTime(){
        System.out.println("Type new end time (example yyyy-MM-dd HH:mm = 2021-12-13 12:30): ");
        return stringToTime();
    }

    public int newTaskInterval(){
        System.out.println("Type new interval in minutes: ");
        return consoleEntry();
    }

    private int consoleEntry() {
        int chosenAction = 0;

        try {
            chosenAction = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e){
            return -1;
        }
        return chosenAction;
    }

    private String consoleStrungEntry() {
        String stringEntry = "";

        try {
            stringEntry = reader.readLine();
        } catch (IOException e){
            logger.error(Errors.UNEXPECTED_DATA);
        }
        return stringEntry;
    }

    public int taskId(){
        System.out.print("Enter id task what you want change: ");
        return consoleEntry();
    }

    public void wrongStartTime(){
        System.out.println("Wrong start time, expected 2021-12-13 12:30");
    }

    public void wrongEndTime(){
        System.out.println("Wrong start time, expected 2021-12-13 12:30");
    }

    public void wrongTime(){
        System.out.println("Wrong start time, expected 2021-12-13 12:30");
    }

    public void wrongInterval(){
        System.out.println("Wrong interval, please type numbers with out letters");
    }

    private LocalDateTime stringToTime(){
        String date = "null";
        LocalDateTime timeHolder = null;

        try {
            date = reader.readLine();
        }catch (IOException | NumberFormatException e){
            logger.error(Errors.UNEXPECTED_DATA);
        }

        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            timeHolder = LocalDateTime.parse(date, dateTimeFormatter);
        }catch (DateTimeParseException e){
            return LocalDateTime.ofEpochSecond(1, 1, ZoneOffset.UTC);
        }
        return timeHolder;
    }
}
