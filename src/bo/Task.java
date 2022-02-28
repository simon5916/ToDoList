package bo;

public class Task {

    protected String taskName;
    protected String taskDescription;
    protected boolean stateValidate;

    public Task(String taskName, String taskDescription, boolean stateValidate){
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.stateValidate = stateValidate;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isStateValidate() {
        return stateValidate;
    }

    public void setStateValidate() {
        this.stateValidate = true;
    }


    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }


}
