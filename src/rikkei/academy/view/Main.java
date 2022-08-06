package rikkei.academy.view;

import rikkei.academy.controller.ClassRoomController;
import rikkei.academy.controller.StudentController;
import rikkei.academy.model.ClassRoom;
import rikkei.academy.model.Student;
import rikkei.academy.service.Class_Room.ClassRoomServiceIMPL;
import rikkei.academy.service.Student.StudentServiceIMPL;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        List<ClassRoom> classroomList = new ClassRoomController().getClassRoomList();
        List<Student> studentList = new StudentController().getStudentList();

        Scanner input = new Scanner(System.in);
        int choice = -1;
        while (choice != 9) {

            System.out.println("=============MENU=============");
            System.out.println("| 1. Show list classrooms    |");
            System.out.println("| 2. Create classroom        |");
            System.out.println("| 3. Edit classroom          |");
            System.out.println("| 4. Delete classroom        |");
            System.out.println("| 5. Show list students      |");
            System.out.println("| 6. Create student          |");
            System.out.println("| 7. Edit student            |");
            System.out.println("| 8. Delete student          |");
            System.out.println("| 9. EXIT                    |");
            System.out.println("==============================");
            choice = getIntegerInput("ENTER YOUR CHOICE");

            switch (choice) {
                case 1:
                    System.out.println("SHOW LIST CLASSROOM");
                    System.out.println(classroomList);
                    break;
                case 2:
                    System.out.println("CREATE CLASSROOM");
                    System.out.println("Enter classroom name: ");
                    String name = input.nextLine();
                    if (name.trim().isEmpty()) {
                        System.out.println("Can't enter blank");
                    } else if (new ClassRoomController().contains(name)) {
                        System.out.println("Classroom already exists");

                    } else {
                        new ClassRoomController().createClassRoom(name);
                        System.out.println("CREATE SUCCESS");
                    }

                    break;
                case 3:
                    System.out.println("EDIT CLASSROOM");
                    int idEdit = getIntegerInput("Enter id: ");
                    if (idEdit > classroomList.size()) {
                        System.out.println("Index out of bounds");
                        break;

                    }
                    System.out.println("Enter classroom name to edit");
                    String editName = input.nextLine();
                    if (editName.trim().isEmpty()) {
                        System.out.println("Can't enter blank");
                        break;
                    }
                    new ClassRoomController().editClassRoom(idEdit, editName);
                    System.out.println("EDIT SUCCES");
                    break;
                case 4:
                    System.out.println("EDIT CLASSROOM");
                    int idDelete = getIntegerInput("Enter id: ");

                    if (idDelete > classroomList.size()) {
                        System.out.println("INDEX OUT OF BOUNDS");
                    } else {
                        new ClassRoomController().delete(idDelete);
                        System.out.println("DELETE SUCCES");
                    }
                    break;
                case 5:
                    System.out.println("SHOW LIST STUDENTS");
                    System.out.println(studentList);
                    break;
                case 6:
                    System.out.println("CREATE STUDENT");
                    System.out.println("CHOOSE CLASSROOM");
                    for (int i = 0; i < classroomList.size(); i++) {
                        System.out.println((i + 1) + "." + classroomList.get(i).getName());


                    }
                    int classID = getIntegerInput("Enter classroom id: ");
                    System.out.println("Enter student id: ");
                    String studentName = input.nextLine();
                    if (studentName.trim().isEmpty()) {
                        System.out.println("Can't enter blank");
                        break;
                    }
                    new StudentController().createStudent(studentName, classID);
                    System.out.println("CREATE SUCCES");
                    break;
                case 7:
                    System.out.println("EDIT STUDENT");
                    int idEditStudent = getIntegerInput("Enter student id: ");
                    if (idEditStudent > studentList.size()) {
                        System.out.println("STUDENT INDEX OUT OF BOUNDS");
                        break;
                    }
                    System.out.println(new StudentController().getStudent(idEditStudent));
                    System.out.println("1. Edit Name");
                    System.out.println("2. Edit classroom");
                    int editChoice = getIntegerInput("Enter choice: ");
                    switch (editChoice) {
                        case 1:
                            System.out.println("Enter student name to edit: ");
                            new StudentController().editStudentName(idEditStudent, input.nextLine());
                            break;
                        case 2:
                            System.out.println("Choose classroom:");
                            for (int i = 0; i < classroomList.size(); i++) {
                                System.out.println((i + 1) + ". " + classroomList.get(i).getName());

                            }
                            int studentClassroomEdit = getIntegerInput("Enter classroom id: ");
                            new StudentController().editStudentClass(idEditStudent, studentClassroomEdit);
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                    System.out.println("EDIT SUCCESS");
                    break;
                case 8:
                    System.out.println("Delete Student");
                    int idDeleteStudent = getIntegerInput("Enter student id");
                    if (idDeleteStudent > studentList.size()) {
                        System.out.println("Index out of bounds");
                        break;
                    }
                    new StudentController().deleteStudent(idDeleteStudent);
                    System.out.println("Delete success");
                    break;
                case 9:
                    System.out.println("Search Student");
                    System.out.println("1. By name");
                    System.out.println("2. By classroom");
                    int searchChoice = getIntegerInput("Enter choice: ");
                    switch (searchChoice) {
                        case 1:
                            System.out.println("Enter student name");
                            String namesearch = input.nextLine();
                            System.out.println(new StudentController().searchStudentByName(namesearch));
                            break;
                        case 2:
                            System.out.println("Choose Classroom");
                            for (int i = 0; i < classroomList.size(); i++) {
                                System.out.println((i + 1) + ". " + classroomList.get(i).getName());

                            }
                            int classroomSearch = getIntegerInput("Enter classroomId: ");
                            System.out.println(new StudentController().searchStudentByClassroom(classroomSearch));
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                    break;
                default:
                    System.out.println("Invalid input, Please try again!!!");
            }
        }
    }

    private static int getIntegerInput(String s) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        do {
            System.out.println(s);
            input = scanner.nextLine();
            if (!input.matches("\\d+")) {
                System.out.println("Invalid input");
            }
        } while (!input.matches("\\d+"));
        return Integer.parseInt(input);
    }
}
