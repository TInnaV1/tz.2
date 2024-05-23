package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProgramService {
    List<String> result = new ArrayList<>();
    public List<String> getAll() {return result;}
    public boolean add(String program) {return result.add(program);}
}
