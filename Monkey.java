public class Monkey extends RescueAnimal {

    // Monkey-specific attributes
    private double tailLength;
    private double height;
    private double bodyLength;
    private String species;

    // Constructor
    public Monkey(String name, double tailLength, double height, double bodyLength,
                  String species, String gender, String age, String weight, String acquisitionDate,
                  String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
    }

    // Accessor Methods
    public double getTailLength() {
        return tailLength;
    }

    public double getHeight() {
        return height;
    }

    public double getBodyLength() {
        return bodyLength;
    }

    public String getSpecies() {
        return species;
    }

    // Mutator Methods
    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setBodyLength(double bodyLength) {
        this.bodyLength = bodyLength;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
