public class ToFahrenheit {

    public double[] transform(UnityTemp tipos, double[] vetortemp) {

        double[] vetorfuture = new double[vetortemp.length];

        if (tipos == UnityTemp.CELSIUS) {

            for ( int i=0; i<vetortemp.length; i++) {
                vetorfuture[i] = ((vetortemp[i] - 32.0) / 1.8);
            }
        } else if (tipos == UnityTemp.KELVIN) {
            for ( int i=0; i<vetortemp.length; i++) {
                vetorfuture[i] = (((vetortemp[i] -32) * 1.8) + 273.15);
            }
        } else {
            return vetortemp;

        }
        return vetorfuture;

    }
}


