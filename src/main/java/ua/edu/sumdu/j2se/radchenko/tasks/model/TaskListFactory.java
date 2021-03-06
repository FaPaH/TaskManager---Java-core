package ua.edu.sumdu.j2se.radchenko.tasks.model;

public class TaskListFactory {
    public static AbstractTaskList createTaskList(ListTypes.types type){
        if (type == ListTypes.types.ARRAY){
            return new ArrayTaskList();
        } else if (type == ListTypes.types.LINKED){
            return new LinkedTaskList();
        } else
            throw new IllegalArgumentException("Not supported type");
    }
}
