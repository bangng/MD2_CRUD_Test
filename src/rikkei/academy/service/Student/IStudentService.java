package rikkei.academy.service.Student;

import rikkei.academy.model.Student;
import rikkei.academy.service.IGeneri;

public interface IStudentService extends IGeneri<Student> {
    void update(Student student);

    void deLete(int index);
}
