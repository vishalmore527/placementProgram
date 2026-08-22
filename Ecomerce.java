/*
calculate shipping charges using overloaded methods
calculateShippingCharges(double weight) 50base+10 perkg
calculate cart total
appply cupon
generate invoice
*/
import java.util.Scanner;

public class Ecomerce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of items");
        int n=sc.nextInt();
        double[] prizes=new double[n];
        for(int i=0;i<n;i++){
            System.out.println("enter prize of item "+(i+1));
            prizes[i]=sc.nextDouble();

        }
            System.out.println("enter weight");
            double weight=sc.nextDouble();

            System.out.println("enter distance ");
            int distance=sc.nextInt();

            boolean expressDelivery=false;
            System.out.println("is express delivery required for item  (y/n)");
            String expressDeliveryInput = sc.nextLine();
            if(expressDeliveryInput.equalsIgnoreCase("y")){
                expressDelivery = true;
            } else {
                expressDelivery = false;
            }
            //boolean expressDelivery=sc.nextBoolean();

            System.out.println("enter coupon code for item ");
            String couponCode=sc.next();

            double shippingCharges = calculateShipping(weight, distance, expressDelivery);
            double cartTotal = calculateCartTotal(prizes);
            double finalTotal = applyCoupon(cartTotal, couponCode, shippingCharges);
            
            generateInvoice(prizes, shippingCharges, finalTotal);

        
    }
       public static double calculateShipping(double weight, int distance, boolean expressDelivery) {
            double shippingCharges = 50 + (10 * weight)+ (2 * distance); // Base charge + weight charge + distance charge
            if (expressDelivery) {
                shippingCharges += 100; // Additional charge for express delivery
            }
            return shippingCharges;
        }

        public static double calculateCartTotal(double[] prizes) {
            double total = 0;
            for (double prize : prizes) {
                total += prize;
            }
            return total;
        }

        public static double applyCoupon(double total, String couponCode, double shippingCharges) {
            double finalTotal = total + shippingCharges;
            if (couponCode.equals("DISCOUNT10")) {
                return finalTotal * 0.9; // 10% discount
            } else if (couponCode.equals("DISCOUNT20")) {
                return finalTotal * 0.8; // 20% discount
            } else {
                return finalTotal; // No discount
            }
        }

        public static void generateInvoice(double[] prizes, double shippingCharges, double finalTotal) {
            System.out.println("Invoice:");
            for (int i = 0; i < prizes.length; i++) {
                System.out.println("Item " + (i + 1) + ": $" + prizes[i]);
            }
            System.out.println("Shipping Charges: $" + shippingCharges);
            System.out.println("Final Total: $" + finalTotal);
        }

       }
    

