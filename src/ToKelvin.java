public class ToKelvin {

    public double[] transform(UnityTemp tipos, double[] vetortemp) {

        double[] vetorfuture = new double[vetortemp.length];

        if (tipos == UnityTemp.CELSIUS) {
            for ( int i=0; i<vetortemp.length; i++) {
                vetorfuture[i] = (vetortemp[i] - 273.15);
            }
        } else if (tipos == UnityTemp.FAHRENHEIT) {
            for ( int i=0; i<vetortemp.length; i++) {
                vetorfuture[i] = (((vetortemp[i] - 273.15) * 1.8) + 32);
            }
        } else {
            return vetortemp;

        }
        return vetorfuture;

    }
}
