CREATE DOMAIN dom_descripcion 	AS 	VARCHAR(255)	NOT NULL;
CREATE DOMAIN dom_codigo 		AS 	VARCHAR(10) 	NOT NULL;
CREATE DOMAIN dom_rif			AS	VARCHAR(10)		NOT NULL;
CREATE DOMAIN dom_teléfonos 	AS 	VARCHAR(15);
CREATE DOMAIN dom_fechas 		AS 	DATE			NOT NULL;
CREATE DOMAIN dom_horas 		AS 	TIME			NOT NULL;
CREATE DOMAIN dom_personas 		AS 	VARCHAR(100)	NOT NULL;
CREATE DOMAIN dom_nombre 		AS 	VARCHAR(255)	NOT NULL;
CREATE DOMAIN dom_direccion 	AS 	VARCHAR(255)	NOT NULL;
CREATE DOMAIN dom_cedula 		AS 	INTEGER			NOT NULL;
CREATE DOMAIN dom_monto 		AS 	REAL			NOT NULL;
CREATE DOMAIN estatusEco 		AS 	CHAR(1) 		NOT NULL CHECK (VALUE IN ('S', 'N'));
CREATE DOMAIN tipodePago 		AS 	CHAR(10)		NOT NULL CHECK (VALUE IN ('Efectivo', 'Transferencia','Debito','Credito'));
CREATE DOMAIN tipodeMoneda 		AS 	CHAR(10)		NOT NULL CHECK (VALUE IN ('Bolivares', 'Dolares'));

CREATE TABLE agencias (
	RIFAg			dom_rif,
	RazonS			VARCHAR(255)		NOT NULL,
	CiudadL			VARCHAR(20)			NOT NULL,
	DireccionAg		dom_direccion,
);
ALTER TABLE agencias ADD CONSTRAINT PK_agencias_RIFAg PRIMARY KEY(RIFAg);
ALTER TABLE agencias ADD CONSTRAINT UQ_agencias_RazonS UNIQUE (RazonS);

CREATE TABLE empleados (
	CIEmp			dom_cedula,
	RIFAg			dom_rif,
	NombreEmp		dom_personas,
	DirecEmp		dom_direccion,
	SueldoEmp		dom_monto,
	TelefEmp		dom_teléfonos		NOT NULL
);
ALTER TABLE empleados ADD CONSTRAINT PK_empleados_CIEmp PRIMARY KEY(CIEmp);
ALTER TABLE empleados ADD CONSTRAINT FK_empleados_RIFAg
FOREIGN KEY (RIFAg) REFERENCES agencias(RIFAg)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE empleados ADD CONSTRAINT CK_empleados_SueldoEmp CHECK(SueldoEmp>0);

CREATE TABLE facturas (
	CodFac			dom_codigo,
	RIFAg			dom_rif,
	FechaFac		dom_fechas,
	MontoFac		dom_monto,
	DetalleFac		VARCHAR(255)		NOT NULL
);
ALTER TABLE facturas ADD CONSTRAINT PK_facturas_CodFac PRIMARY KEY(CodFac);
ALTER TABLE facturas ADD CONSTRAINT FK_facturas_RIFAg
FOREIGN KEY (RIFAg) REFERENCES agencias(RIFAg)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE facturas ADD CONSTRAINT CK_facturas_Monto CHECK(MontoFac>0);

CREATE TABLE clientes (
	CedulaCt		dom_cedula,
	RIFAg			dom_rif,
	CodFac			dom_codigo,
	NombreCt		dom_personas,
	EmailCt			VARCHAR(255),
	Telef1			dom_teléfonos		NOT NULL,
	Telef2			dom_teléfonos
);
ALTER TABLE clientes ADD CONSTRAINT PK_clientes_CedulaCt PRIMARY KEY(CedulaCt);
ALTER TABLE clientes ADD CONSTRAINT FK_clientes_RIFAg
FOREIGN KEY (RIFAg) REFERENCES agencias(RIFAg)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE clientes ADD CONSTRAINT FK_clientes_CodFac
FOREIGN KEY (CodFac) REFERENCES facturas(CodFac)
ON DELETE NO ACTION ON UPDATE CASCADE;

CREATE TABLE vehiculos (
	CodVeh			dom_codigo,
	PlacaVeh		VARCHAR(8)		NOT NULL,
	CedulaCt		dom_cedula,
	AceiteUt		VARCHAR(255)	NOT NULL,
	FechaAdq		dom_fechas,
	MarcaVeh		VARCHAR(100)	NOT NULL,
	ModeloVeh		VARCHAR(50)		NOT NULL
);
ALTER TABLE vehiculos ADD CONSTRAINT PK_vehiculos_CodVeh PRIMARY KEY(CodVeh);
ALTER TABLE vehiculos ADD CONSTRAINT UQ_vehiculos_PlacaVeh UNIQUE (PlacaVeh);
ALTER TABLE vehiculos ADD CONSTRAINT FK_vehiculos_CedulaCt
FOREIGN KEY (CedulaCt) REFERENCES clientes(CedulaCt)
ON DELETE NO ACTION ON UPDATE CASCADE;

CREATE TABLE servicios (
	CodServ			dom_codigo,
        RIFAg			dom_rif,
	CIEmp			dom_cedula,
	NombServ		dom_nombre,
	DescServ		dom_descripcion,
	TiempoResv		VARCHAR(50),
	MontoServ		dom_monto
	CapacServ		INTEGER				NOT NULL
);
ALTER TABLE servicios ADD CONSTRAINT PK_servicios_CodServ PRIMARY KEY(CodServ);
ALTER TABLE servicios ADD CONSTRAINT FK_servicios_RIFAg
FOREIGN KEY (RIFAg) REFERENCES agencias(RIFAg)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE servicios ADD CONSTRAINT FK_servicios_CIEmp
FOREIGN KEY (CIEmp) REFERENCES empleados(CIEmp)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE servicios ADD CONSTRAINT CK_servicios_Monto CHECK(MontoServ>0);
ALTER TABLE servicios ADD CONSTRAINT CK_servicios_CapacServo CHECK(CapacServ>0);

CREATE TABLE modalidadpago (
	TipoPago		tipodePago
);
ALTER TABLE modalidadpago ADD CONSTRAINT PK_modalidadpago_TipoPago PRIMARY KEY(TipoPago);

CREATE TABLE lineasuministros (
	CodLS			dom_codigo,
	NombLS			dom_nombre
);
ALTER TABLE lineasuministros ADD CONSTRAINT PK_lineasuministros_CodLS PRIMARY KEY(CodLS);

CREATE TABLE productos (
	CodPr			dom_codigo,
	NombPr			dom_nombre,
	CodLS			dom_codigo,
	MaxPr			INTEGER				NOT NULL,
	MinPr			INTEGER				NOT NULL,
	PrecioPr		dom_monto,
	EcoPr			estatusEco,
	DescPr			dom_descripcion,
	FabriPr			dom_nombre,
	CantActual		INTEGER				NOT NULL
);
ALTER TABLE productos ADD CONSTRAINT PK_cproductos_CodPr PRIMARY KEY(CodPr);
ALTER TABLE productos ADD CONSTRAINT FK_productos_CodLS
FOREIGN KEY (CodLS) REFERENCES lineasuministros(CodLS)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE productos ADD CONSTRAINT CK_productos_MaxMin CHECK(MaxPr>MinPr);
ALTER TABLE productos ADD CONSTRAINT CK_productos_Min CHECK(MinPr>0);
ALTER TABLE productos ADD CONSTRAINT CK_productos_ActualMin CHECK(CantActual>MinPr);
ALTER TABLE productos ADD CONSTRAINT CK_productos_MaxActual CHECK(MaxPr>CantActual);
ALTER TABLE productos ADD CONSTRAINT CK_productos_Precio CHECK(PrecioPr>0);

CREATE TABLE actividades (
	CodServ			dom_codigo,
	N_Conse			SERIAL				NOT NULL,
	NombAc			dom_nombre,
	CapacidadAc		INTEGER				NOT NULL,
	DescripAc		dom_descripcion,
	MontoAc			dom_monto
);
ALTER TABLE actividades ADD CONSTRAINT PK_actividades_CodServ PRIMARY KEY(CodServ,N_Conse);
ALTER TABLE actividades ADD CONSTRAINT FK_actividades_CodServ
FOREIGN KEY (CodServ) REFERENCES servicios(CodServ)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE actividades ADD CONSTRAINT CK_actividades_Monto CHECK(MontoAc>0);
ALTER TABLE actividades ADD CONSTRAINT CK_actividades_Capacidad CHECK(CapacidadAc>0);

CREATE TABLE ordenesservicio (
	N_Unic			SERIAL				NOT NULL,
	CodVeh			dom_codigo,
	CodServ			dom_codigo,
	N_Conse			SERIAL				NOT NULL,
	ROFecha			dom_fechas,
	ROHora			dom_horas,
	RIFecha			dom_fechas,
	RIHora			dom_horas,
	EOFecha			dom_fechas,
	EOHora			dom_horas,
	Autorizado		dom_nombre,
	MontoTotal		dom_monto
);
ALTER TABLE ordenesservicio ADD CONSTRAINT PK_ordenesservicio_N_Unic PRIMARY KEY(N_Unic);
ALTER TABLE ordenesservicio ADD CONSTRAINT FK_ordenesservicio_Actv
FOREIGN KEY (CodServ,N_Conse) REFERENCES actividades(CodServ,N_Conse)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE ordenesservicio ADD CONSTRAINT FK_ordenesservicio_CodVeh
FOREIGN KEY (CodVeh) REFERENCES vehiculos(CodVeh)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE ordenesservicio ADD CONSTRAINT CK_ordenesservicio_Fecha CHECK(ROFecha>RIFecha);
ALTER TABLE ordenesservicio ADD CONSTRAINT CK_ordenesservicio_Hora CHECK(ROHora>RIHora);
ALTER TABLE ordenesservicio ADD CONSTRAINT CK_ordenesservicio_EstimadoF CHECK(RIFecha>EOFecha);
ALTER TABLE ordenesservicio ADD CONSTRAINT CK_ordenesservicio_EstimadoH CHECK(RIHora>EOHora);

CREATE TABLE productousado (
	CodPr			dom_codigo,
	NUnicOS			SERIAL				NOT NULL,
	CantidadPr		INTEGER				NOT NULL
);
ALTER TABLE productousado ADD CONSTRAINT PK_productousado_CodPr PRIMARY KEY(CodPr,NUnicOS);
ALTER TABLE productousado ADD CONSTRAINT FK_productousado_Pr
FOREIGN KEY (CodPr) REFERENCES productos(CodPr)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE productousado ADD CONSTRAINT FK_productousado_OS
FOREIGN KEY (NUnicOS) REFERENCES ordenesservicio(N_Unic)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE productousado ADD CONSTRAINT CK_productousado_Cantidad CHECK(CantidadPr>0);

CREATE TABLE cuentan (
	RIFAg			dom_rif,
	CodServ			dom_codigo,
	CapacServ		INTEGER				NOT NULL
);
ALTER TABLE cuentan ADD CONSTRAINT PK_cuentan_RIFsERV PRIMARY KEY(RIFAg,CodServ);
ALTER TABLE cuentan ADD CONSTRAINT FK_cuentan_RIFAg
FOREIGN KEY (RIFAg) REFERENCES agencias(RIFAg)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE cuentan ADD CONSTRAINT FK_cuentan_OS
FOREIGN KEY (CodServ) REFERENCES servicios(CodServ)
ON DELETE NO ACTION ON UPDATE CASCADE;

CREATE TABLE utilizan (
	CodPr			dom_codigo,
	NUnicOS			SERIAL				NOT NULL,
	CIEmp			dom_cedula
);
ALTER TABLE utilizan ADD CONSTRAINT PK_utilizan_PrEmp PRIMARY KEY(CodPr,NUnicOS,CIEmp);
ALTER TABLE utilizan ADD CONSTRAINT FK_utilizan_CodPrUs
FOREIGN KEY (CodPr,NUnicOS) REFERENCES productousado(CodPr,NUnicOS)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE utilizan ADD CONSTRAINT FK_utilizan_CIEmp
FOREIGN KEY (CIEmp) REFERENCES empleados(CIEmp)
ON DELETE NO ACTION ON UPDATE CASCADE;

CREATE TABLE aceptan (
	CodFac			dom_codigo,
	TipoPago		tipodePago,
	TipoMoneda		tipodeMoneda,
	FechaNac		dom_fechas,
	NroTarj			VARCHAR(16),
	BancoTarj		VARCHAR(255),
	Monto			dom_monto
);
ALTER TABLE aceptan ADD CONSTRAINT PK_aceptan_FacPago PRIMARY KEY(CodFac,TipoPago);
ALTER TABLE aceptan ADD CONSTRAINT FK_aceptan_CodFac
FOREIGN KEY (CodFac) REFERENCES facturas(CodFac)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE aceptan ADD CONSTRAINT FK_aceptan_TipoPago
FOREIGN KEY (TipoPago) REFERENCES modalidadpago(TipoPago)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE aceptan ADD CONSTRAINT CK_aceptan_Monto CHECK(Monto>0);

CREATE TABLE tienen (
	CodFac			dom_codigo,
	CodServ			dom_codigo,
	N_Conse			SERIAL				NOT NULL
);
ALTER TABLE tienen ADD CONSTRAINT PK_tienen_FacServ PRIMARY KEY(CodFac,CodServ);
ALTER TABLE tienen ADD CONSTRAINT FK_tienen_CodFac
FOREIGN KEY (CodFac) REFERENCES facturas(CodFac)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE tienen ADD CONSTRAINT FK_tienen_Activ
FOREIGN KEY (CodServ,N_Conse) REFERENCES actividades(CodServ,N_Conse)
ON DELETE NO ACTION ON UPDATE CASCADE;

CREATE TABLE asignan (
	CodServ			dom_codigo,
	CIEmp			dom_cedula
);
ALTER TABLE asignan ADD CONSTRAINT PK_asignan_ServEmp PRIMARY KEY(CodServ,CIEmp);
ALTER TABLE asignan ADD CONSTRAINT FK_asignan_CodServ
FOREIGN KEY (CodServ) REFERENCES servicios(CodServ)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE asignan ADD CONSTRAINT FK_asignan_CIEmp
FOREIGN KEY (CIEmp) REFERENCES empleados(CIEmp)
ON DELETE NO ACTION ON UPDATE CASCADE;

CREATE TABLE encargado (
	RIFAg			dom_rif,
	CIEncargado		dom_cedula,
	FechaEnc		dom_fechas
);
ALTER TABLE encargado ADD CONSTRAINT PK_encargado_RIFEmp PRIMARY KEY(RIFAg,CIEncargado);
ALTER TABLE encargado ADD CONSTRAINT FK_encargado_RIFAg
FOREIGN KEY (RIFAg) REFERENCES agencias(RIFAg)
ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE encargado ADD CONSTRAINT FK_encargado_CIEncargado
FOREIGN KEY (CIEncargado) REFERENCES empleados(CIEmp)
ON DELETE NO ACTION ON UPDATE CASCADE;

