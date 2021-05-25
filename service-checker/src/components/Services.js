import React from 'react'
    
const Services = ({ services }) => {
    return (
    <div>
        {services.map((service) => (
            <div class="card">
                <div class="card-body">
                    <h3 class="card-title">{service.name}</h3>
                    <h5 class="card-subtitle mb-2 text-muted">URL: {service.url}</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Status: {service.status}</h6>
                    <h7 class="card-subtitle mb-2 text-muted">Last changed: {service.lastChanged}</h7>
                </div>
            </div>
        ))}
    </div>
    )
};

export default Services