public class MlpMain {

    public static double[][][] baseI = {
            {{0, 0}, {0}},
            {{0, 1}, {0}},
            {{1, 0}, {0}},
            {{1, 1}, {1}}
    };

    public static double[][][] baseII = {
            {{0, 0}, {0}},
            {{0, 1}, {1}},
            {{1, 0}, {1}},
            {{1, 1}, {1}}
    };

    public static double[][][] baseIII = {
            {{0, 0}, {0}},
            {{0, 1}, {1}},
            {{1, 0}, {1}},
            {{1, 1}, {0}}
    };

    public static double[][][] baseIV = {
            {{0, 0, 0}, {1, 1}},
            {{0, 0, 1}, {0, 1}},
            {{0, 1, 0}, {1, 0}},
            {{0, 1, 1}, {0, 1}},
            {{1, 0, 0}, {1, 0}},
            {{1, 0, 1}, {1, 0}},
            {{1, 1, 0}, {1, 0}},
            {{1, 1, 1}, {1, 0}}
    };

    public static void main(String[] argsng) {
        /*
         AND (Base I) - 2 entradas, 1 saída, 2 neurônios ocultos (exemplo)
        */
        MlpImp mlpAnd = new MlpImp(2, 1, 2);
        for (int epoch = 0; epoch < 10000; epoch++) {
            double err = 0.0;
            for (int i = 0; i < baseI.length; i++) {
                double[] out = mlpAnd.train(baseI[i][0], baseI[i][1]);
                err += Math.abs(out[0] - baseI[i][1][0]);
            }
            System.out.printf("[MLP AND] Epoch: %d - Error: %.4f%n", epoch, err);
        }

        /*
         OR (Base II) - 2 entradas, 1 saída
         */
        MlpImp mlpOr = new MlpImp(2, 1, 2);
        for (int epoch = 0; epoch < 10000; epoch++) {
            double err = 0.0;
            for (int i = 0; i < baseII.length; i++) {
                double[] out = mlpOr.train(baseII[i][0], baseII[i][1]);
                err += Math.abs(out[0] - baseII[i][1][0]);
            }
            System.out.printf("[MLP OR] Epoch: %d - Error: %.4f%n", epoch, err);
        }

        /*
         XOR (Base III) - 2 entradas, 1 saída (MLP deve resolver)
         */
        MlpImp mlpXor = new MlpImp(2, 1, 3);
        for (int epoch = 0; epoch < 10000; epoch++) {
            double err = 0.0;
            for (int i = 0; i < baseIII.length; i++) {
                double[] out = mlpXor.train(baseIII[i][0], baseIII[i][1]);
                err += Math.abs(out[0] - baseIII[i][1][0]);
            }
            System.out.printf("[MLP XOR] Epoch: %d - Error: %.4f%n", epoch, err);
        }

        /*
         Robô (Base IV) - 3 entradas, 2 saídas
         */
        MlpImp mlpRobo = new MlpImp(3, 2, 4);
        for (int epoch = 0; epoch < 10000; epoch++) {
            double err = 0.0;
            for (int i = 0; i < baseIV.length; i++) {
                double[] out = mlpRobo.train(baseIV[i][0], baseIV[i][1]);
                for (int j = 0; j < baseIV[i][1].length; j++) {
                    err += Math.abs(out[j] - baseIV[i][1][j]);
                }
            }
            System.out.printf("[MLP ROBO] Epoch: %d - Error: %.4f%n", epoch, err);
        }
    }
}

