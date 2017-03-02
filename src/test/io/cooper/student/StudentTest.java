package io.cooper.student;

import io.cooper.student.model.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by skehtch on 2/28/17.
 */
public class StudentTest {

    private List<Student> students;

    @Before
    public void setUp() throws Exception {

        students  = new ArrayList<>();

        Student amy = new Student("Amy", 24, "f");
        Student clive = new Student("Clive", 22, "m");
        Student johnny = new Student("Johnny", 22, "m");
        Student lucy = new Student("Lucy", 24, "f");

        students.add(amy);
        students.add(clive);
        students.add(johnny);
        students.add(lucy);

    }

    @Test
    public void testDistinctOffListOfStudents(){

        List<Student> distinctStudents = students.stream().filter(distinctByKey(student -> student.getAge() + student.getSex())).map(e -> e).collect(Collectors.toList());
        assertEquals(2, distinctStudents.size());

    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
