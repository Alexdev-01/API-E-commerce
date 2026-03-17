```text
📦 com.tiendaonline.gestion
│
├── 📁 controller  → Controladores REST
│   ├── AuthController
│   ├── ProductoController
│   ├── CategoriaController
│   └── PedidoController
│
├── 📁 service  → Lógica de negocio (interfaces)
│   ├── AuthService
│   ├── ProductoService
│   ├── CategoriaService
│   └── PedidoService
│
├── 📁 service/impl  → Implementaciones
│   ├── AuthServiceImpl
│   ├── ProductoServiceImpl
│   ├── CategoriaServiceImpl
│   └── PedidoServiceImpl
│
├── 📁 repository  → Acceso a datos (JPA)
│   ├── UsuarioRepository
│   ├── ProductoRepository
│   ├── CategoriaRepository
│   ├── PedidoRepository
│   └── DetallePedidoRepository
│
├── 📁 model  → Entidades (Base de datos)
│   ├── Usuario
│   ├── Producto
│   ├── Categoria
│   ├── Pedido
│   └── DetallePedido
│
├── 📁 dto  → Transferencia de datos
│   ├── 📁 auth
│   └── 📁 pedido
│
└── 📁 security  → Seguridad JWT
│   ├── config
│   ├── jwt
│   └── service
│
└── 📄 ApiRestGestionTareasApplication.java

```
