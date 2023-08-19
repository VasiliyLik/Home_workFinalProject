package interfacesAndAnnotations;

import enums.Faculties;

import java.util.List;
import java.util.NavigableMap;

public interface DisplayFaculties {

    NavigableMap<Double, Faculties> displayFacultiesRating();

    List<Double> displayPercentagePaidEducation();

    List<Double> displayAverageScoreForPaidEducation(Faculties faculties);

}
