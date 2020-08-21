package Stack;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Program {

    public static void main(String[] args) {

        int numStudents = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de estudiantes que desea ingresar: "));
        ArrayList<Student> students = getArrayStudents(numStudents);
        displayResult(students);
    }

    // Método que retorna un array de estudiantes dependiendo de la cantidad ingresada
    public static ArrayList<Student> getArrayStudents(int numStudents) {

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < numStudents; i++) {

            Student student = new Student();
            student.name = JOptionPane.showInputDialog("Escriba el nombre del estudiante:");
            student.payment = Float.parseFloat(JOptionPane.showInputDialog("Escriba el valor a pagar:"));
            students.add(student);
        }
        return students;
    }

    // Método que imprime en pantalla el resultado del promedio del estudiante que mas paga
    public static void displayResult(ArrayList<Student> students) {

        float value = calculate(students);
        JOptionPane.showMessageDialog(null, "El promedio entre el estudiante que mas paga es de: " + value);
    }

    public static float calculate(ArrayList<Student> students) {

        // estudiante que mas paga
        Student HigherStudent = getStudentWitHigherPayment(students);

        // promedio del pago de los estudiantes
        float avg = getAvgByStudents(students);
        
        return getDiffAvg(HigherStudent.payment, avg);
    }

    // Método que hacer la operacion matematica para obtener la diferencia entre el promedio de un valor
    public static float getDiffAvg(float payment, float avg) {
        return payment - avg;
    }

    // Método que obtiene el estudiante que mas paga
    public static Student getStudentWitHigherPayment(ArrayList<Student> students) {

        Student student = new Student();
        for (Student std : students) {
            if (std.payment > student.payment) {
                student = std;
            }
        }
        return student;
    }

    // Método que obtiene el promedio de una lista de estudiantes
    public static float getAvgByStudents(ArrayList<Student> students) {

        float totalPayment = 0;
        for (Student std : students) {
            totalPayment = totalPayment + std.payment;
        }
        return totalPayment / students.size();
    }
}
