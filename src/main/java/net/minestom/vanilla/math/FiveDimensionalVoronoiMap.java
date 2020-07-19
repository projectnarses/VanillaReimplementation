package net.minestom.vanilla.math;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * Not thread safe
 *
 * 5D Voronoi map that allows to get the closest value (5D vector) to a given 5D vector
 */
public class FiveDimensionalVoronoiMap<ElementType> {

    private final List<Vec5D> elements = new LinkedList<>();

    public FiveDimensionalVoronoiMap() {}

    public FiveDimensionalVoronoiMap add(Vec5D<ElementType> element) {
        elements.add(element);
        return this;
    }

    public Vec5D<ElementType> get(double x, double y, double z, double w, double theta) {
        if(elements.isEmpty()) {
            throw new UnsupportedOperationException("No underlying elements");
        }
        Vec5D<ElementType> closest = elements.get(0);
        double closestDist = closest.sqDist(x, y, z, w, theta);
        for (int i = 1; i < elements.size(); i++) {
            Vec5D<ElementType> element = elements.get(i);
            double dist = element.sqDist(x, y, z, w, theta);
            if(dist < closestDist) {
                closest = element;
                closestDist = dist;
            }
        }

        return closest;
    }

    @Data
    public static class Vec5D<UserObject> {
        private final double x;
        private final double y;
        private final double z;
        private final double w;
        private final double theta;
        private final UserObject userObject;

        public double sqDist(Vec5D<UserObject> other) {
            return sqDist(other.x, other.y, other.z, other.w, other.theta);
        }

        public double sqDist(double x, double y, double z, double w, double theta) {
            double dx = x - this.x;
            double dy = y - this.y;
            double dz = z - this.z;
            double dw = w - this.w;
            double dt = theta - this.theta;
            return dx*dx+dy*dy+dz*dz+dw*dw+dt*dt;
        }
    }
}
