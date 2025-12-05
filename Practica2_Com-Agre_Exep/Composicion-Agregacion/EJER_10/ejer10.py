#Nicol Yanina Ticona Aduviri
#CI:6786427

class Persona:
    def __init__(self, nombre, apellido, edad, ci):
        self.nombre = nombre
        self.apellido = apellido
        self.edad = edad
        self.ci = ci

class Participante(Persona):
    def __init__(self, nombre, apellido, edad, ci, nroTicket):
        super().__init__(nombre, apellido, edad, ci)
        self.nroTicket = nroTicket

class Speaker(Persona):
    def __init__(self, nombre, apellido, edad, ci, especialidad):
        super().__init__(nombre, apellido, edad, ci)
        self.especialidad = especialidad

class Charla:
    def __init__(self, lugar, nombreCharla, speaker):
        self.lugar = lugar
        self.nombreCharla = nombreCharla
        self.speaker = speaker
        self.participantes = []   

    def agregar_participante(self, p):
        self.participantes.append(p)

    @property
    def cantidad_participantes(self):
        return len(self.participantes)


class Evento:
    def __init__(self, nombre):
        self.nombre = nombre
        self.charlas = []  
    def agregar_charla(self, charla):
        self.charlas.append(charla)

# Speakers
sp1 = Speaker("Ana", "Lopez", 40, 101, "Data Science")
sp2 = Speaker("Carlos", "Gomez", 45, 202, "Ciberseguridad")
sp3 = Speaker("Maria", "Perez", 38, 303, "IA")

# Participantes
p1 = Participante("Luis", "Ramos", 25, 501, 1)
p2 = Participante("Jose", "Diaz", 30, 502, 2)
p3 = Participante("Ana", "Lopez", 40, 101, 3)  # mismo nombre/CI que speaker 1 para prueba del punto B
p4 = Participante("Lucia", "Mendez", 28, 503, 4)

# Charlas
c1 = Charla("Sala A", "Introducción a IA", sp1)
c1.agregar_participante(p1)
c1.agregar_participante(p2)

c2 = Charla("Sala B", "Seguridad Digital", sp2)
c2.agregar_participante(p3)

c3 = Charla("Sala C", "Automatización", sp3)
c3.agregar_participante(p4)
c3.agregar_participante(p1)

# Evento
evento = Evento("TechDay")
evento.agregar_charla(c1)
evento.agregar_charla(c2)
evento.agregar_charla(c3)



# -------------------------------------------------------------
# A) Edad promedio de los participantes del evento
# -------------------------------------------------------------
def edad_promedio(evento):
    participantes = []
    for charla in evento.charlas:
        participantes.extend(charla.participantes)

    promedio = sum(p.edad for p in participantes) / len(participantes)
    return promedio


# -------------------------------------------------------------
# B) Verificar si persona X Y está como participante o speaker
# -------------------------------------------------------------
def persona_en_evento(evento, nombre, apellido):
    for charla in evento.charlas:
        if charla.speaker.nombre == nombre and charla.speaker.apellido == apellido:
            return True
        for p in charla.participantes:
            if p.nombre == nombre and p.apellido == apellido:
                return True
    return False


# -------------------------------------------------------------
# C) Eliminar charlas de un speaker por CI
# -------------------------------------------------------------
def eliminar_charlas_por_ci(evento, ci):
    evento.charlas = [c for c in evento.charlas if c.speaker.ci != ci]


# -------------------------------------------------------------
# D) Ordenar charlas por cantidad de participantes
# -------------------------------------------------------------
def ordenar_charlas(evento):
    evento.charlas.sort(key=lambda c: c.cantidad_participantes)



# =============================================================
#                   IMPRESIÓN
# =============================================================

print("A) Edad promedio de participantes =", edad_promedio(evento))

print("\nB) ¿'Ana Lopez' está en el evento? →",
      persona_en_evento(evento, "Ana", "Lopez"))

print("\nC) Eliminando charlas del speaker con CI=202 (Carlos Gomez)...")
eliminar_charlas_por_ci(evento, 202)

print("Charlas restantes:")
for c in evento.charlas:
    print(" -", c.nombreCharla)

print("\nD) Charlas ordenadas por # de participantes:")
ordenar_charlas(evento)
for c in evento.charlas:
    print(f"{c.nombreCharla}: {c.cantidad_participantes} participantes")
