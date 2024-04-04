package cwk4;

public class WizardTester {
    public static void main(String[] args) {
        // Create a Wizard object
        Wizard wizard1 = new Wizard("Merlin", 10, 50, true, "Elemental");

        // Print out the details of the wizard using toString method
        System.out.println("Details of Wizard 1:");
        System.out.println(wizard1);

        // Update some properties of the wizard
        wizard1.setSpellSpeciality("Arcane");

        // Print out the updated details of the wizard
        System.out.println("\nUpdated Details of Wizard 1:");
        System.out.println(wizard1);

        // Create another Wizard object
        Wizard wizard2 = new Wizard("Wololo", 8, 60, true,  "Necromancy");
        Wizard wizard3 = new Wizard("NecroMaster", 8, 60, true,"Necromancy");

        // Print out the details of the second wizard
        System.out.println("\nDetails of Wizard 2:");
        System.out.println(wizard2);
    }
}