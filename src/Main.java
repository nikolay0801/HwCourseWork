public class Main {
    static Employee[] employees = new Employee[10];
// static - чтоб работать с массивом из мейна

    public static void main(String[] args) {
        for (int i = 0; i < employees.length; i++) {
            employees[0] = new Employee("Иванов Иван Иванович", 1, 10000);
            employees[1] = new Employee("Петров Петр сергеевич", 3, 15000);
            employees[2] = new Employee("Сергеев Андрей Генадьевич", 3, 20000);
            employees[3] = new Employee("Андросов Андрей Сергеевич", 4, 30000);
            employees[4] = new Employee("Сидоров Иван Иванович", 3, 40000);
            employees[5] = new Employee("Смирнов Иван Иванович", 2, 50000);
            employees[6] = new Employee("Семенов Семен Ивановыч", 3, 70000);
            employees[7] = new Employee("Юг Юрий Михайлович", 6, 10000);
            employees[8] = new Employee("Аксенов Петр Сергеевич", 3, 9000);
            employees[9] = new Employee("Самсонов Сергей андреевич", 5, 8000);
        }
        System.out.println(" Сумма всех зарплат равняеться " + sallarySum(3));
        System.out.println("Сотрудник с минимальной зарплатой " + findMin(3));
        System.out.println("Сотрудник с максимальной зарплатой " + findMax(3));
        System.out.println("Средняя сумма зарплат " + getAvarege(3));
        printFullName(3);
        raiseSallary(30, 3);
        System.out.println();
        printAll();


    }

    public static void printAll() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void printAll(int department) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println(employee);
            }
        }
    }

    public static double sallarySum() {
        // написал double чтобы посчитаная сумма вернулась.
        double salary = 0.0;
        for (Employee employee : employees) {
            salary += employee.getSallary();
            // считаем сумму всех зарплат сотрудников
        }
        return salary;
    }

    public static double sallarySum(int department) {

        double salary = 0.0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                salary += employee.getSallary();
            }
        }
        return salary;
    }

    public static Employee findMin() {
        // Ищем сотрудника с минималной зарплатой
        Employee minEmployy = null;
        for (Employee employee : employees) {
            // пройдемся циклом по данным
            if (minEmployy == null || employee.getSallary() < minEmployy.getSallary()) {
                minEmployy = employee;
                // Добавили проверку на null
                // Так же сделали проверку, если зарпалата < той, что у нас написана,то мы нашли минмальноо сотрудника.
                // || =  "или "
            }
        }
        return minEmployy;
        // return возвращаеть действие.
    }

    public static Employee findMin(int department) {
        Employee minEmployy = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            if (minEmployy == null || employee.getSallary() < minEmployy.getSallary()) {
                minEmployy = employee;
            }
        }

        return minEmployy;

    }

    public static Employee findMax() {
        Employee maxEmployee = null;
        for (Employee employee : employees) {
            if (maxEmployee == null || employee.getSallary() > maxEmployee.getSallary()) {
                maxEmployee = employee;
            }
        }
        return maxEmployee;

    }

    public static Employee findMax(int department) {
        Employee maxEmployee = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            if (maxEmployee == null || employee.getSallary() > maxEmployee.getSallary()) {
                maxEmployee = employee;
            }
        }

        return maxEmployee;

    }

    public static double getAvarege() {
        return sallarySum() / employees.length;
        // общую сумму делим на размер массива,таким образом я нашел среднюю зарплату
    }

    public static double getAvarege(int department) {
        double summ = 0.0;
        int quantity = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department){
                continue;
            }
            summ+= employee.getSallary();
            quantity++;

        }
        return summ/quantity;

    }

    public  static void printFullName(){
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
            // получил ФИО всех сотруднков
        }
    }
    public  static void printFullName(int department){
        for (Employee employee : employees) {
            if (employee.getDepartment() != department){
                continue;
            }
            System.out.println(employee.getFullName());

        }
    }
    public static void raiseSallary( int prozent){
        double koef = 1 +  prozent / 100.0;
        for (Employee employee : employees) {
            employee.setSallary(employee.getSallary() * koef);
        }
    }
    public static void raiseSallary( int prozent, int department){
        double koef = 1 +  prozent / 100.0;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department){
                continue;
            }
            employee.setSallary(employee.getSallary() * koef);
        }
    }
}

