

<style>*{host:inital}</style>

<style type="text/css">

@import url("my-bootstrap.min.css");

.box-shadow {
	box-shadow: 0 .25rem .75rem rgba(0, 0, 0, .05);
}
</style>


<div class="card mb-4 box-shadow">
	<img style="cursor: pointer" class="card-img-top" src="Hello.svg" alt="Card image cap">
	<div class="card-body">
		<p class="card-text">
		 <%=System.currentTimeMillis()%> from JSP <%=response.getContentType()%></p>
		<div class="d-flex justify-content-between align-items-center">
			<div class="btn-group">
				<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
				<button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
			</div>
			<small class="text-muted">9 mins</small>
		</div>
	</div>
</div>