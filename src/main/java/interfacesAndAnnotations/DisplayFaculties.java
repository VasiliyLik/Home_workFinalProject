package interfacesAndAnnotations;

import enums.Faculties;
import org.apache.commons.math3.util.Pair;

import java.util.Map;

public interface DisplayFaculties {

    Map<Double, Faculties> displayFacultiesRating();

    Pair<Double, Double> displayPercentagePaidEducation();

    Pair<Double, Double> displayAverageScoreForPaidEducation(Faculties faculties);

}
