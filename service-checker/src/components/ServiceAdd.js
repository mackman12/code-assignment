import React from 'react'
import {useState} from 'react'

const ServiceAdd = () => {

	const [name, setName] = useState('');
	const [url, setUrl] = useState('');

	const changeName = (e) => {
		setName(e.target.value);
	};

	const changeUrl = (e) => {
		setUrl(e.target.value);
	};

	const onClick = (e) =>  {
		if(name!=='' && url!=='')
			fetch('http://localhost:8080/service/add', {
				method: 'POST',
				headers: { 'Content-Type': 'application/json' },
				body: JSON.stringify({name:name, url:url })
			})
	}

	return (
		<div>
			<form>
				<label>
					<span class="text">Name:</span>
					<input type="text" value={name} onChange={changeName} required/><br />
				</label>
				<label>
					<span class="text">URL:</span>
					<input type="text" value={url} onChange={changeUrl} required/><br />
				</label>
				<button onClick={onClick}>Submit</button>
			</form>
		</div>
	)

}

export default ServiceAdd