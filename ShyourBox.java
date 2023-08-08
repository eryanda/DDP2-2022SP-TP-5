import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Aplikasi ShyourBox untuk manajemen pembelian produk dan pembuatan struk.
 */
public class ShyourBox {
    private List<Product> products = new ArrayList<>();
    private List<Cart> carts = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    /**
     * Method utama untuk menjalankan aplikasi ShyourBox.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam aplikasi ini).
     */
    public static void main(String[] args) {
        ShyourBox shyourboxApp = new ShyourBox();
        System.out.println("Welcome to ShyourBox! Yuk beli jangan shy shy!");

        // Subject to change: file addresses.
        String productAddress = "input/daftarProduk.txt";
        String customerAddress = "input/daftarCustomer.txt";

        shyourboxApp.addCustomer(customerAddress);
        shyourboxApp.addProduct(productAddress);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMenu" +
                    "\n1. Beli Produk" +
                    "\n2. Cari Produk" +
                    "\n3. Print Struk" +
                    "\n0. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    shyourboxApp.buyProduct(scanner);
                    break;
                case 2:
                    System.out.print("Cari produk dengan nama: ");
                    String name = scanner.nextLine();
                    shyourboxApp.searchProduct(name, choice);
                    break;
                case 3:
                    shyourboxApp.printReceipt();
                    break;
                case 0:
                    System.out.println("Yay!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }

    /**
     * Memproses pembelian produk oleh customer.
     *
     * @param scanner Scanner untuk input dari pengguna.
     */
    public void buyProduct(Scanner scanner) {
        System.out.print("Masukkan nama customer: ");
        String customerName = scanner.nextLine();
        System.out.println();
        Customer customer = findCustomer(customerName);
        if (customer == null) {
            System.out.println("Mohon maaf, customer atas nama " + customerName + " tidak terdaftar!");
            return;
        }

        Cart cart = new Cart(customer);

        System.out.println("====MASUKKAN ITEM KE KERANJANG====");
        String productName;
        do {
            System.out.print("Masukkan nama produk (atau tekan 'X' untuk selesai): ");
            productName = scanner.nextLine();
            if (productName.equalsIgnoreCase("X")) {
                break;
            }
            int choice = 1;
            Product product = searchProduct(productName, choice);
            if (product == null) {
                System.out.println("Mohon maaf, produk tidak tersedia!");
            } else {
                System.out.print("Masukkan Jumlah (kg): ");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                if (product.getStock() >= quantity) {
                    OrderItem orderItem = new OrderItem(product, quantity);
                    cart.addOrderItem(orderItem);
                    System.out.println("Produk Berhasil ditambahkan!");
                    product.setStock(product.getStock() - quantity);
                } else {
                    System.out.println("Mohon maaf, stok tidak mencukupi!");
                }
            }
        } while (!productName.equalsIgnoreCase("X"));

        carts.add(cart);
        System.out.println("Terima kasih sudah berbelanja, " + customerName + "!");
    }

    /**
     * Mencari produk berdasarkan nama.
     *
     * @param name   Nama produk yang dicari.
     * @param choice Pilihan fitur yang digunakan.
     * @return Produk yang ditemukan atau null jika tidak ditemukan.
     */
    public Product searchProduct(String name, int choice) {
        for (Product product : products) {
            if (product.getNama().equalsIgnoreCase(name)) {
                if(choice == 1){
                    return product;
                }
                if(product.getClass().getSimpleName().equals("Fruit")){
                    Fruit fruit = (Fruit) product;
                    System.out.println("\n[" + "Buah " + (fruit.isLocal() ? "Lokal" : "Impor") + "]");
                    System.out.println("Nama Produk: " + product.getNama());
                    System.out.println("Harga: " + product.getPrice());
                    System.out.println("Stok: " + product.getStock());
                    return product;
                }
                else if (product.getClass().getSimpleName().equals("Veggie")){
                    Veggie veggie = (Veggie) product;
                    System.out.println("\n[" + "Sayur " + (veggie.isOrganic() ? "Organik" : "Konvensional") + "]");
                    System.out.println("Nama Produk: " + product.getNama());
                    System.out.println("Harga: " + product.getPrice());
                    System.out.println("Stok: " + product.getStock());
                    return product;
                }
            } 
        }
        System.out.println("Produk tersebut tidak ada");
        return null;
    }

    /**
     * Menambahkan produk dari file txt ke dalam daftar produk.
     *
     * @param fileAddress Alamat file produk.
     */
    public void addProduct(String fileAddress) {
        try {
            Scanner fileScanner = new Scanner(new java.io.File(fileAddress));
            int successCount = 0;
            int failCount = 0;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] productData = line.split(", ");
                if (productData.length == 5) {
                    String type = productData[0];
                    String name = productData[1];
                    int price = Integer.parseInt(productData[2]);
                    int stock = Integer.parseInt(productData[3]);
                    boolean isLocalOrOrganic = productData[4].equalsIgnoreCase("Lokal") || productData[4].equalsIgnoreCase("Organik");

                    Product product;
                    if (type.equalsIgnoreCase("Fruit")) {
                        product = new Fruit(name, price, stock, isLocalOrOrganic);
                    } else if (type.equalsIgnoreCase("Veggie")) {
                        product = new Veggie(name, price, stock, isLocalOrOrganic);
                    } else {
                        failCount++;
                        continue; // Skip the invalid product data
                    }
                    products.add(product);
                    successCount++;
                } else {
                    failCount++;
                }
            }
            fileScanner.close();
            System.out.println("Berhasil menambahkan " + successCount + " Produk");
            if (failCount > 0) {
                System.out.println("Gagal menambahkan " + failCount + " Produk");
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File produk tidak ditemukan.");
        } catch (NumberFormatException e) {
            System.out.println("Format data produk tidak valid.");
        }
    }

     /**
     * Menambahkan customer dari file txt ke dalam daftar customer.
     *
     * @param fileAddress Alamat file customer.
     */
    public void addCustomer(String fileAddress) {
        try {
            Scanner fileScanner = new Scanner(new java.io.File(fileAddress));
            int successCount = 0;
            int failCount = 0;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] customerData = line.split(", ");
                if (customerData.length == 2) {
                    String name = customerData[0];
                    boolean isPremium = customerData[1].equalsIgnoreCase("premium");
                    if(customerData[1].equals("premium") || customerData[1].equals("reguler")){
                        Customer customer = new Customer(name, isPremium);
                        customers.add(customer);
                        successCount++; 
                    }
                    else{
                        failCount++;
                    }
                } else {
                    failCount++;
                }
            }
            fileScanner.close();
            System.out.println("Berhasil menambahkan " + successCount + " Customer");
            if (failCount > 0) {
                System.out.println("Gagal menambahkan " + failCount + " Customer");
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File customer tidak ditemukan.");
        }
    }

    /**
     * Mencetak struk perbelanjaan ke dalam file txt.
     */
    public void printReceipt() {
        try {
            FileWriter writer = new FileWriter("Struk.txt");
            writer.write("Berikut adalah rekap perbelanjaan hari ini:\n\n");
            for (Cart cart : carts) {
                Customer customer = cart.getCustomer();
                writer.write("=============================\n");
                writer.write("Nama Customer: " + customer.getName() + "\n");
                writer.write("Daftar Belanja:\n");
                for (OrderItem orderItem : cart.getOrderList()) {
                    Product product = orderItem.getProduct();
                    int quantity = orderItem.getQuantity();
                    int finalPrice = orderItem.getFinalPrice();

                    writer.write(product.getNama() + "  " + quantity + "kg  " + finalPrice + "\n");
                }
                int totalPrice = cart.calculateTotalPrice();
                writer.write("\nTotal Perbelanjaan: " + totalPrice + "\n");
            }
            writer.close();
            System.out.println("Struk telah disimpan dalam file Struk.txt");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan struk.");
        }
    }

    /**
     * Mencari customer berdasarkan nama.
     *
     * @param name Nama customer yang dicari.
     * @return Customer yang ditemukan atau null jika tidak ditemukan.
     */
    public Customer findCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }
}
