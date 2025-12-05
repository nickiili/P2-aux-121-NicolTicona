#Nicol Yanina Ticona Aduviri
#6786427
class Empleado:
    def __init__(self, nombre, puesto, salario):
        self.nombre = nombre
        self.puesto = puesto
        self.salario = salario

    def __str__(self):
        return f"{self.nombre} | Puesto: {self.puesto} | Salario: {self.salario}"
class Empresa:
    def __init__(self, nombre):
        self.nombre = nombre
        self.empleados = []  

    # a) Agregar empleado
    def agregar_empleado(self, empleado):
        self.empleados.append(empleado)

    # b) Mostrar empresa y empleados
    def mostrar_empresa(self):
        print(f"\nEmpresa: {self.nombre}")
        print("Lista de empleados:")
        if not self.empleados:
            print("No hay empleados registrados.")
        else:
            for emp in self.empleados:
                print(" -", emp)

    # c) Buscar empleado por nombre
    def buscar_empleado(self, nombre):
        for emp in self.empleados:
            if emp.nombre.lower() == nombre.lower():
                return emp
        return None

    # d) Eliminar empleado por nombre
    def eliminar_empleado(self, nombre):
        for emp in self.empleados:
            if emp.nombre.lower() == nombre.lower():
                self.empleados.remove(emp)
                print(f"Empleado '{nombre}' eliminado.")
                return
        print(f"No se encontró el empleado '{nombre}'.")

    # e1) Promedio salarial
    def promedio_salarial(self):
        if not self.empleados:
            print("No hay empleados.")
            return
        promedio = sum(emp.salario for emp in self.empleados) / len(self.empleados)
        print(f"Promedio salarial: {promedio:.2f}")

    # e2) Listar empleados con salario mayor a X
    def listar_mayores_a(self, valor):
        print(f"\nEmpleados con salario mayor a {valor}:")
        encontrados = [emp for emp in self.empleados if emp.salario > valor]

        if not encontrados:
            print("Ningún empleado supera ese salario.")
        else:
            for emp in encontrados:
                print(" -", emp)
                
if __name__ == "__main__":

    empresa = Empresa("TechSolutions")

    # a) Agregar empleados
    empresa.agregar_empleado(Empleado("Ana", "Ingeniera", 4500))
    empresa.agregar_empleado(Empleado("Luis", "Administrador", 3000))
    empresa.agregar_empleado(Empleado("María", "Programadora", 5200))
    empresa.agregar_empleado(Empleado("Carlos", "Diseñador", 2800))

    # b) Mostrar empresa
    empresa.mostrar_empresa()

    # c) Buscar empleado
    print("\nBuscando a María:")
    encontrado = empresa.buscar_empleado("María")
    print(encontrado if encontrado else "No encontrada.")

    # d) Eliminar empleado
    empresa.eliminar_empleado("Luis")
    empresa.mostrar_empresa()

    # e) Promedio salarial
    empresa.promedio_salarial()

    # e) Listar salario mayor a X
    empresa.listar_mayores_a(4000)
