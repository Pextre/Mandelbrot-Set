import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Mandelbrot  {
    public static void main(String[] args) throws Exception {
        int largura = 3840;
        int altura = 2160;
        BufferedImage imagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
        int preto = 0x000000;
        int maximo = 10000;
        int color[] = new int[maximo];
        for(int i =0 ; i<maximo ; i++){
            //Alterar os valores de i para obter cores diferentes
            color[i] = ( (i<<16) | (i*2<<8) | (i*4)<<0);//ConjuntoMandelbrot.png

        }

        for (int coluna = 0; coluna < largura; coluna++) {
            for (int linha = 0; linha < altura; linha++) {
                double x0 = (coluna - (largura/2.0))/altura*2.5;
                double y0 = (linha - (altura/2.0))/altura*2.5;
                double x = 0;
                double y = 0;
                int iteracao = 0;

                while ((x * x + y * y < 4) && (iteracao < maximo)) {
                    double novoX = x * x - y * y + x0;//se adiciona essa parte porque os valores de x
                    // e y devem ser os originais , porem o y muda na proxima linha e isso alteraria o valor4
                    y = 2 * x * y + y0;
                    x = novoX;
                    iteracao++;
                }

                if (iteracao < maximo) {
                    imagem.setRGB(coluna, linha, color[iteracao]);
                } else {
                    imagem.setRGB(coluna, linha, preto);
                }

            }


        }
        ImageIO.write(imagem, "png", new File("ConjuntoMandelbrot.png"));
    }

}

