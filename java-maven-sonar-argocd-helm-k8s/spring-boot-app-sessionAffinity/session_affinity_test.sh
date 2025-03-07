#!/bin/bash

# Define the service URL (replace with your actual service URL)
SERVICE_URL="http://10.101.157.245"  # Update with your ClusterIP

echo "Testing session affinity for $SERVICE_URL"
echo "----------------------------------------"

# Run multiple requests
for i in {1..10}; do
    RESPONSE=$(curl -s $SERVICE_URL)

    # Extract the Pod IP from the response
    POD_IP=$(echo "$RESPONSE" | grep -oP '(?<=Pod IP: ).*')

    # Print the response
    if [ -n "$POD_IP" ]; then
        echo "Pod IP: $POD_IP"
    else
        echo "Pod IP: Unknown"
    fi

    sleep 1  # Adding a small delay between requests
done

echo "----------------------------------------"
