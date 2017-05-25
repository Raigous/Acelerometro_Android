package com.example.u15191.novoprojeto;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateFilter;
<<<<<<< HEAD
=======
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
>>>>>>> Morrrrreu
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.util.GeometricShapeFactory;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by u15191 on 26/04/2017.
 */


public class FazTudo extends View {


    public float getxInMap1() {
        return xInMap1;
    }

    public void setxInMap1(float xInMap1) {
        this.xInMap1 = xInMap1;
    }

    public float getyFinMap1() {
        return yFinMap1;
    }

    public void setyFinMap1(float yFinMap1) {
        this.yFinMap1 = yFinMap1;
    }

    public float getyInMap1() {
        return yInMap1;
    }

    public void setyInMap1(float yInMap1) {
        this.yInMap1 = yInMap1;
    }

    public float getxFinMap1() {
        return xFinMap1;
    }

    public void setxFinMap1(float xFinMap1) {
        this.xFinMap1 = xFinMap1;
    }

    public void setxFinMap2(float xFinMap2) {
        this.xFinMap2 = xFinMap2;
    }

    public float getxInMap2() {
        return xInMap2;
    }

    public void setxInMap2(float xInMap2) {
        this.xInMap2 = xInMap2;
    }

    public float getyInMap2() {
        return yInMap2;
    }

    public void setyInMap2(float yInMap2) {
        this.yInMap2 = yInMap2;
    }

    public float getyFinMap2() {
        return yFinMap2;
    }

    public void setyFinMap2(float yFinMap2) {
        this.yFinMap2 = yFinMap2;
    }

    public float getxFinMap2() {
        return xFinMap2;
    }

    public void translateBola(final double deltaX, final double deltaY) {
        bola.apply(new CoordinateFilter() {
            public void filter(Coordinate coordinate) {
                coordinate.x += deltaX;
                coordinate.y += deltaY;
            }
        });
    }

    public double getXBola() {
        return bola.getCentroid().getX();
    }

    public double getYBola() {
        return bola.getCentroid().getY();
    }

    public float xInMap1;
    public float yInMap1;
    public float yFinMap1;
    public float xFinMap1;
    public float xInMap2;
    public float yInMap2;
    public float yFinMap2;
    public float xFinMap2;
    private int score = 0;

    private Paint paint = new Paint();
    private Paint paint2 = new Paint();
    private Paint paint3 = new Paint();
    private Path path = new Path();
    private Random random = new Random();
    private Boolean primeiraVez = true;

    private LinkedList<Coordinate> linhas1;
    private LinkedList<Coordinate> linhas2;
    private Polygon bola;

    private static float DELTA_Y = 30;
    private static float MAX_DELTA_X = 4 * DELTA_Y;
    private GeometryFactory gesao;


    public static Polygon createCircle(double x, double y, final double RADIUS) {
        GeometricShapeFactory shapeFactory = new GeometricShapeFactory();
        shapeFactory.setNumPoints(32);
        shapeFactory.setCentre(new Coordinate(x, y));
        shapeFactory.setSize(RADIUS * 2);
        return shapeFactory.createCircle();
    }

    public FazTudo(Context context, AttributeSet attrs, float xs, float ys) {
        super(context, attrs);
        bola = createCircle(xs, ys, 65);

<<<<<<< HEAD
=======
        gesao = new GeometryFactory();
>>>>>>> Morrrrreu

        this.setxInMap1(370);
        this.setyInMap1(1700);
        this.setxFinMap1(370);
        this.setyFinMap1(-200);
        this.setxInMap2(720);
        this.setyInMap2(1700);
        this.setxFinMap2(720);
        this.setyFinMap2(-200);


        paint.setAntiAlias(true);
        paint.setStrokeWidth(6f);
        paint.setTextSize(30);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeJoin(Paint.Join.ROUND);

        paint3.setAntiAlias(true);
        paint3.setStrokeWidth(6f);
        paint3.setTextSize(60);
        paint3.setColor(Color.MAGENTA);
        paint3.setStyle(Paint.Style.FILL);
        paint3.setStrokeJoin(Paint.Join.ROUND);

        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(20f);
        paint2.setColor(Color.BLUE);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeJoin(Paint.Join.ROUND);

        linhas1 = new LinkedList<>();
        linhas2 = new LinkedList<>();

        linhas1.addFirst(new Coordinate(xInMap1, yInMap1));
        linhas2.addFirst(new Coordinate(xInMap2, yInMap2));
        linhas1.addFirst(new Coordinate(xFinMap1, yFinMap1));
        linhas2.addFirst(new Coordinate(xFinMap2, yFinMap2));
        this.invalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        float bola_x = (float) bola.getCentroid().getX();
        float bola_y = (float) bola.getCentroid().getY();


        canvas.drawCircle(
                bola_x,
                bola_y,
                65, paint);
        score ++;
        canvas.drawText("Score: " + score, 750, 100, paint3);
        generatePoints();
        desenharLinha(canvas);
    }

    private void generatePoints() {
        for (Coordinate g :
                linhas1) {
            g.y += 6;
        }

        for (Coordinate g :
                linhas2) {
            g.y += 6;
        }

        float deltaX = random.nextInt((int) MAX_DELTA_X) - MAX_DELTA_X / 2 + 11 / MAX_DELTA_X;


        if ((linhas1.getFirst().x + deltaX) < 66) {
            deltaX = random.nextInt((int) MAX_DELTA_X) / 2;
        }

        if ((linhas2.getFirst().x + deltaX) > 1010) {
            deltaX = -1 * random.nextInt((int) MAX_DELTA_X) / 2;
        }

        Coordinate cn1 = new Coordinate(linhas1.getFirst().x + deltaX, linhas1.getFirst().y - DELTA_Y);
        Coordinate cn2 = new Coordinate(linhas2.getFirst().x + deltaX, linhas2.getFirst().y - DELTA_Y);

        linhas1.addFirst(cn1);
        linhas2.addFirst(cn2);

        if (linhas1.getFirst().y > yInMap1) {
            linhas1.removeLast();
            linhas2.removeLast();
        }
    }

    private void desenharLinha(Canvas c) {
        Coordinate g = null;
        for (Coordinate h :
                linhas1) {
            if (g == null) {
                g = h;
                continue;
            }
            c.drawLine(((float) g.x), ((float) g.y), ((float) h.x), ((float) h.y), paint2);
            g = h;
        }

        g = null;
        for (Coordinate h :
                linhas2) {
            if (g == null) {
                g = h;
                continue;
            }
            c.drawLine(((float) g.x), ((float) g.y), ((float) h.x), ((float) h.y), paint2);
            g = h;
        }
    }

    public boolean isColidiu() {
        Coordinate[] cs1 = {};
        Coordinate[] cs2 = {};

        LineString linha1 = gesao.createLineString((linhas1.toArray(cs1)));
        LineString linha2 = gesao.createLineString((linhas1.toArray(cs1)));

        return bola.intersects(linha1) ||
                bola.intersects(linha2);

    }
}