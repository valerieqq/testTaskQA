package main.Enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return this.gender;
    }

    private static final List<Gender> values =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int size = values.size();
    private static final Random random = new Random();

    public static Gender randomGender()  {
        return values.get(random.nextInt(size));
    }
}
