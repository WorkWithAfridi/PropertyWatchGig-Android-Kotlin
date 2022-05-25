import com.example.propertywatch.database.Property

fun loadData(): ArrayList<Property> {
    val propertyArray: ArrayList<Property> = ArrayList()
    propertyArray.add(
        Property(
        address="149-153 Bunda Street, Cairns",
        price=200000,
        phone="0403404111",
        lat=-16.928893272553427, lon=145.77021565990813)
    )
    propertyArray.add(
        Property(
        address="197 Draper Street, Cairns",
        price=350000,
        phone="0403404222",
        lat=-16.928893272553427, lon=145.77021565990813)
    )
    propertyArray.add(
        Property(
        address="198 Grafton Street, Cairns",
        price=800000,
        phone="0403404333",
        lat=-16.916479904985984, lon=145.76987256094102)
    )
    propertyArray.add(
        Property(
        address="3 Cominos Place, Cairns",
        price=550000,
        phone="0403404444",
        lat=-16.922791, lon=145.745504)
    )
    propertyArray.add(
        Property(
        address="6 McGuigan Street, Earlville",
        price=400000,
        phone="0403404555",
        lat=-16.945571, lon=145.741207)
    )
    propertyArray.add(
        Property(
        address="6-8 Quigley Street, Manunda",
        price=455000,
        phone="0403404666",
        lat=-16.929026, lon=145.762279)
    )
    return propertyArray
//    saveProperties(propertyArray)
}