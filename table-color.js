
$(document).ready(function () {
    var x = $("td.status")
    for (var i = 0; i < x.length; i++) {
        if ($(x[i]).html() == "PENDING") {
            $(x[i]).html('<h5 class="text-primary">PENDING</h5>')
        } 
        else if ($(x[i]).html() == "REJECTED") {
            $(x[i]).html('<h5 class="p-3 mb-2 bg-danger text-white">REJECTED</h5>')
        }
        else {
        	 $(x[i]).html('<h5 class="p-3 mb-2 bg-success text-white text-success">APPROVED</h5>')
        }
    }
});